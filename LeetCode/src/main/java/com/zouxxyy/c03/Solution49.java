package com.zouxxyy.c03;

/*
349. 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]


说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution49 {

    public int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {

            while (i + 1 < nums1.length && nums1[i + 1] == nums1[i]) {
                i++;
            }

            while (j + 1 < nums2.length && nums2[j + 1] == nums2[j]) {
                j++;
            }

            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }

        }

        int[] res = new int[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++) {
            res[i1] = list.get(i1);
        }

        return res;
    }
}
