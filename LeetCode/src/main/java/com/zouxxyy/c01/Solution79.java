package com.zouxxyy.c01;

/*
179. 最大数
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。

注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。



示例 1：

输入：nums = [10,2]
输出："210"
示例 2：

输入：nums = [3,30,34,5,9]
输出："9534330"
示例 3：

输入：nums = [1]
输出："1"
示例 4：

输入：nums = [10]
输出："10"


提示：

1 <= nums.length <= 100
0 <= nums[i] <= 109
 */

import java.util.Arrays;

/**
 * @author zxy
 */
public class Solution79 {

    public String largestNumber(int[] nums) {

        String[] s = new String[nums.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, (o1, o2) -> {

            int i = 0, j = 0;
            String s1 = o1 + o2;
            String s2 = o2 + o1;

            while (i < s1.length() && j < s2.length()) {
                if (s1.charAt(i) < s2.charAt(j)) {
                    return -1;
                } else if (s1.charAt(i) > s2.charAt(j)) {
                    return 1;
                }
                i++;
                j++;
            }

            return 0;
        });

        if ("0".equals(s[s.length - 1])) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            sb.append(s[i]);
        }

        return sb.toString();
    }

}
