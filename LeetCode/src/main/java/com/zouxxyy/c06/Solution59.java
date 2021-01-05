package com.zouxxyy.c06;

/*
659. 分割数组为连续子序列
给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。

如果可以完成上述分割，则返回 true ；否则，返回 false 。



示例 1：

输入: [1,2,3,3,4,5]
输出: True
解释:
你可以分割出这样两个连续子序列 :
1, 2, 3
3, 4, 5


示例 2：

输入: [1,2,3,3,4,4,5,5]
输出: True
解释:
你可以分割出这样两个连续子序列 :
1, 2, 3, 4, 5
3, 4, 5


示例 3：

输入: [1,2,3,4,4,5]
输出: False


提示：

输入的数组长度范围为 [1, 10000]
 */

/**
 * @author zxy
 */
public class Solution59 {

    public boolean isPossible(int[] nums) {

        // 以 pre 结尾 的子序列的个数
        int dp1 = 0;
        int dp2 = 0;
        int dp3 = 0;

        int i = 0;

        while (i < nums.length) {

            int start = i;

            // 计算 cur 的个数 cnt
            int cur = nums[i];
            while (i < nums.length && nums[i] == cur) {
                i++;
            }
            int cnt = i - start;

            if (start > 0 && cur == nums[start - 1] + 1) {

                // cur == pre + 1 时

                int left = cnt - dp1 - dp2;

                if (left < 0) {
                    // 不能满足把 子序列的个数为 1 和 2 的延伸时，直接失败
                    return false;
                } else {
                    // 延伸 1 和 2 后，为了尽可能不产生新序列，尽可能增加序列长度
                    // keep 是可以继续在 子序列的个数为 3 的基础上延伸的个数
                    int keep = Math.min(left, dp3);
                    dp3 = keep + dp2;
                    dp2 = dp1;
                    dp1 = left - keep;
                }

            } else {

                // 第一个数 或者 cur ！= pre + 1 时，dp 重新计算
                if (dp1 != 0 || dp2 != 0) {
                    return false;
                } else {
                    dp1 = cnt;
                    dp2 = 0;
                    dp3 = 0;
                }
            }

        }

        return dp1 == 0 && dp2 == 0;
    }

}
