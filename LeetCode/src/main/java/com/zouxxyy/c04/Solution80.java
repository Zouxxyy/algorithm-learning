package com.zouxxyy.c04;

/*
480. 滑动窗口中位数
中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。

例如：

[2,3,4]，中位数是 3
[2,3]，中位数是 (2 + 3) / 2 = 2.5
给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。



示例：

给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。

窗口位置                      中位数
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7      -1
 1  3 [-1  -3  5] 3  6  7      -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。



提示：

你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution80 {

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] res = new double[nums.length - k + 1];
        ArrayList<Integer> list = new ArrayList<>(k);

        int i = 0;
        while (i < k) {
            list.add(nums[i]);
            i++;
        }

        Collections.sort(list);
        int index = 0;
        res[index++] = getMid(list);

        while (i < nums.length) {
            remove(list, nums[i - k]);
            add(list, nums[i]);
            res[index++] = getMid(list);
            i++;
        }

        return res;
    }

    private void add(ArrayList<Integer> list, int num) {

        if (list.size() == 0 || list.get(0) > num) {

            list.add(0, num);

        } else {

            int l = 0, r = list.size() - 1;

            // 2 分左端点模板
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (list.get(mid) <= num) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }

            list.add(l + 1, num);
        }
    }

    private void remove(ArrayList<Integer> list, int num) {

        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) == num) {
                list.remove(mid);
                return;
            } else if (list.get(mid) < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

    }

    private double getMid(ArrayList<Integer> list) {

        int length = list.size();
        if (length % 2 == 1) {
            return list.get(length / 2);
        } else {
            return ((double) list.get((length - 1) / 2) + list.get(length / 2)) / 2;
        }

    }

}
