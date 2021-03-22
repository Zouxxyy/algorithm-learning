package com.zouxxyy.c00;

/*
4. 寻找两个正序数组的中位数
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。



示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
示例 3：

输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
示例 4：

输入：nums1 = [], nums2 = [1]
输出：1.00000
示例 5：

输入：nums1 = [2], nums2 = []
输出：2.00000


提示：

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106


进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */

/**
 * @author zxy
 */
public class Solution04 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l = 0, r = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int num = (n1 + n2) / 2 + 1;
        int last = 0, cur = 0;

        for (int k = 0; k < num; k++) {
            last = cur;
            if (l == n1) {
                cur = nums2[r++];
            } else if (r == n2) {
                cur = nums1[l++];
            } else if (nums1[l] <= nums2[r]) {
                cur = nums1[l++];
            } else {
                cur = nums2[r++];
            }

        }
        return ((n1 + n2) % 2) == 0 ? (double) (last + cur) / 2 : cur;
    }

}
