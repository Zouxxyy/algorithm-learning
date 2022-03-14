package com.zouxxyy.c03;

/*
368. 最大整除子集
给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
answer[i] % answer[j] == 0 ，或
answer[j] % answer[i] == 0
如果存在多个有效解子集，返回其中任何一个均可。



示例 1：

输入：nums = [1,2,3]
输出：[1,2]
解释：[1,3] 也会被视为正确答案。
示例 2：

输入：nums = [1,2,4,8]
输出：[1,2,4,8]


提示：

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
nums 中的所有整数 互不相同
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zxy
 */
public class Solution68 {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        // dp[i]：只看前 i 个数，以当前数为结尾的所需数组的最大长度
        // 转移方程：最小为 1，遍历 dp[0:i-1]，找到符合添加（和它可以整除）的最大长度

        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        int[] t = new int[nums.length];

        // 1. 填充 dp 和 转移数组
        for (int i = 0; i < nums.length; i++) {

            // 最小就是该数（如果前面没有符合的）
            int maxLen = 1;
            int pre = i;

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + dp[j] > maxLen) {
                    maxLen = 1 + dp[j];
                    pre = j;
                }
            }

            dp[i] = maxLen;
            t[i] = pre;
        }

        // 2. 找到最大长度 和 对应下标
        int maxLen = 0;
        int index = 0;

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                index = i;
            }
        }

        // 3. 根据转移数组倒推
        ArrayList<Integer> res = new ArrayList<>(maxLen);
        for (int i = 0; i < maxLen; i++) {
            res.add(nums[index]);
            index = t[index];
        }

        return res;

    }


}
