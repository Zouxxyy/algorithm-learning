package com.zouxxxyy.search;

/*
插值查找

仅适用顺序表的查找
二分查找的改进版，mid值按比例取：mid = left + (target - arr[left]) / (arr[right] - arr[left]) * (right - left)

时间复杂度：O(logn)
空间复杂度：O(1)
 */

/**
 * @author zxy
 */
public class InterpolationSearch {

    public static boolean interpolationSearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {

            int mid = left + (target - arr[left]) / (arr[right] - arr[left]) * (right - left);

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
