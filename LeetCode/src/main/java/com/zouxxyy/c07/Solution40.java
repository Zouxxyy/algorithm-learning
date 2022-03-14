package com.zouxxyy.c07;

import java.util.*;

/*
740. 删除并获得点数
给你一个整数数组 nums ，你可以对它进行一些操作。

每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。

开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。



示例 1：

输入：nums = [3,4,2]
输出：6
解释：
删除 4 获得 4 个点数，因此 3 也被删除。
之后，删除 2 获得 2 个点数。总共获得 6 个点数。
示例 2：

输入：nums = [2,2,3,3,3,4]
输出：9
解释：
删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
总共获得 9 个点数。


提示：

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 104
 */

/**
 * @author zxy
 */
public class Solution40 {

    public int deleteAndEarn(int[] nums) {

        Arrays.sort(nums);
        int res = 0;
        int cur = nums[0];
        int rob = 0, notRob = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                cur += nums[i];
            } else {

                int temp = rob;
                rob = Math.max(rob, notRob + cur);
                notRob = Math.max(temp, notRob);
                cur = nums[i];

                if (nums[i] - nums[i - 1] > 1) {
                    res += Math.max(rob, notRob);
                    rob = 0;
                    notRob = 0;
                }
            }
        }

        int temp = rob;
        rob = Math.max(rob, notRob + cur);
        notRob = Math.max(temp, notRob);

        return res + Math.max(rob, notRob);
    }

}
