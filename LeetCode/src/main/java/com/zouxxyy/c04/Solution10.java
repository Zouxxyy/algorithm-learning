package com.zouxxyy.c04;

/*
410. 分割数组的最大值
给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。

注意:
数组长度 n 满足以下条件:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
示例:

输入:
nums = [7,2,5,10,8]
m = 2

输出:
18

解释:
一共有四种方法将nums分割为2个子数组。
其中最好的方式是将其分为[7,2,5] 和 [10,8]，
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 */

/*
思路：

使用二分 求解 最小的最大值 问题
 */

/*
模板：
首先是求最小问题，使用二分的左边界模板
check 里解决 最大值分析
 */

/**
 * @author zxy
 */
public class Solution10 {

    public int splitArray(int[] nums, int m) {

        // 确定边界
        int l = 0;
        int r = 0;

        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        // 求最小，使用二分的左边界模板
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (check(nums, m, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }


    /**
     * 是否可以将数组分成 m 个子数组，且子数组和 <= max
     */
    private boolean check(int[] nums, int m, int max) {

        // count 是在和最大值不超过 max 时的最小分割点数
        int count = 1;
        int sum = 0;

        for (int num : nums) {

            if (sum + num <= max) {
                sum += num;
            } else {
                count++;
                sum = num;
            }

        }

        return count <= m;
    }

}
