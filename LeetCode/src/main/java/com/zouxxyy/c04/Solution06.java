package com.zouxxyy.c04;

/*
406. 根据身高重建队列
假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

/*
思路：

两种方法：先处理最矮，先处理最高的（更优）
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution06 {

    /**
     * 方法一：贪心：先处理最矮的
     */
    public int[][] reconstructQueue(int[][] people) {

        if (people.length <= 1) {
            return people;
        }

        // [4,4], [5,0], [5,2], [6,1], [7,0], [7,1]
        Arrays.sort(people, (o1, o2) -> o1 != o2 ? o1[0] - o2[0] : o1[1] - o2[1]);

        int[][] res = new int[people.length][2];
        for (int[] re : res) {
            re[0] = -1;
        }

        for (int[] person : people) {
            // person 是当前最矮的，k 是它前面的人数
            int k = person[1];

            for (int i = 0; i < res.length; i++) {

                // k = 0 后，填坑
                if (k == 0) {
                    if (res[i][0] == -1) {
                        res[i] = person;
                        break;
                    }
                } else if (res[i][0] == -1 || res[i][0] >= person[0]) {
                    // 该位置为空(-1)，那么它肯定比当前的高。（因为剩下的都是比他高的）
                    k--;
                }
            }
        }

        return res;
    }

    /**
     * 方法二：贪心：先处理最高的
     */
    public int[][] reconstructQueue2(int[][] people) {

        if (people.length <= 1) {
            return people;
        }

        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        Arrays.sort(people, ((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]));

        LinkedList<int[]> list = new LinkedList<>();

        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[people.length][2]);
    }

}
