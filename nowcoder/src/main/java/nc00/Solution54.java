package nc00;

/*
数组中相加和为0的三元组

给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
注意：
三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
解集中不能包含重复的三元组。
例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, 0, 10) (-10, -10, 20)

示例1
输入
复制
[-2,0,1,1,2]
返回值
复制
[[-2,0,2],[-2,1,1]]
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution54 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {

            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int sum = num[i] * -1;

            // 两数和
            int l = i + 1, r = num.length - 1;
            while (l < r) {

                if (num[l] + num[r] == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[l]);
                    list.add(num[r]);
                    res.add(list);

                    while (++l < num.length && num[l] == num[l - 1]) {
                    }
                    while (--r > 0 && num[r] == num[r + 1]) {
                    }

                } else if (num[l] + num[r] < sum) {
                    while (++l < num.length && num[l] == num[l - 1]) {
                    }

                } else {
                    while (--r > 0 && num[r] == num[r + 1]) {
                    }
                }

            }

        }

        return res;

    }

}
