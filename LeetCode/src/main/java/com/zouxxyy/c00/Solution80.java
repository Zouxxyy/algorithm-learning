package com.zouxxyy.c00;

/**
 * @author zxy
 */
public class Solution80 {

    public int removeDuplicates(int[] nums) {

        boolean twice = false;
        int cur = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                twice = false;
                nums[cur++] = nums[i];
            } else if (!twice) {
                twice = true;
                nums[cur++] = nums[i];
            }

        }

        return cur;
    }

}
