package nc00;

/*
数组中的最长连续子序列

题目描述
给定无序数组arr，返回其中最长的连续序列的长度(要求值连续，位置可以不连续,例如 3,4,5,6为连续的自然数）
示例1
输入
复制
[100,4,200,1,3,2]
返回值
复制
4
示例2
输入
复制
[1,1,1]
返回值
复制
1
备注:
1 \leq n \leq 10^51≤n≤10
5

1 \leq arr_i \leq 10^81≤arr
i
​
 ≤10
8
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution95 {

    public int MLS(int[] arr) {
        // write code here

        int res = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int cnt = 1;
            while (set.contains(++num)) {
                cnt++;
            }
            res = Math.max(res, cnt);
        }
        return res;

    }

}
