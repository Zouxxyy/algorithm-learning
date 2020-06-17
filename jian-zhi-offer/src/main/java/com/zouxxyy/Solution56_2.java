/*
面试题56 - II. 数组中数字出现的次数 II

在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

 

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1
 

限制：

1 <= nums.length <= 10000
1 <= nums[i] < 2^31

 */

/*
笔记：

通用方法，如果其他数字出现了 n 次，那么把同一位相加 % n，就是出现一次的数在该位的值
 */

package com.zouxxyy;

public class Solution56_2 {
    public int singleNumber(int[] nums) {
        int[] sum = new int[32];
        for (int num : nums) {
            int temp = num;
            for (int i = 0; i < 32; i++) {
                sum[i] += temp & 1;
                temp >>= 1;
            }
        }
        int ret = 0;
        for (int i = 0; i < sum.length; i++) {
            ret |= (sum[i] % 3) << i;
        }
        return ret;
    }
}
