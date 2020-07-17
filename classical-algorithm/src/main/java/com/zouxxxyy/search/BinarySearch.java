package com.zouxxxyy.search;

/*
二分查找

仅适用顺序表的查找！

时间复杂度：O(logn)
空间复杂度：O(1)
 */

/**
 * @author zxy
 */
public class BinarySearch {

    public static boolean binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        // 注意是 <=
        while (left <= right) {

            int mid = left + (right - left) / 2;

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
