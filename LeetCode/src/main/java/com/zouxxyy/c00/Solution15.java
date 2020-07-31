package com.zouxxyy.c00;

import java.util.*;

/*
15. 三数之和

给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 */

/*
思路：

排序后 + 双指针
 */

/**
 * @author zxy
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new LinkedList<>();

        // 由于后面至少要有两个数，因此 i < nums.length - 2
        for (int i = 0; i < nums.length - 2; i++) {

            // 第一个数字去重
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 把问题转化为两数之和，由于已排序，可采用双指针解法
            int target = -1 * nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {

                // 第二个数字去重
                if (left != i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }

                // 第三个数字去重
                if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }

                int sum = nums[left] + nums[right];

                if (sum == target) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }

            }

        }

        return res;
    }

}
