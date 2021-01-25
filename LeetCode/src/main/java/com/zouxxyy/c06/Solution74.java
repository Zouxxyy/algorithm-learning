package com.zouxxyy.c06;

/**
 * @author zxy
 */
public class Solution74 {

    public int findLengthOfLCIS(int[] nums) {

        int res = 0;
        int pre = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                res = Math.max(res, i - pre);
                pre = i;
            }
        }

        return Math.max(res, nums.length - pre);
    }

}
