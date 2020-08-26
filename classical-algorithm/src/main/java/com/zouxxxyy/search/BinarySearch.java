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

    // 只有一个数满足条件

    /**
     * 求满足条件的数的 index
     */
    public static int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        // 注意是 <=
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 多个数满足条件，通常用于求极值问题

    /**
     * 求满足条件的最左边的那个数的 index
     * <p>
     * 假设条件是 >= 4
     * 1 2 3 3 4 4 4 5 5 6 7 8
     *         | -------------
     */
    public static int binarySearchL(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left < right) {

            // 求左边界 mid 往左靠
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 求满足条件的最右边的那个数的 index
     * <p>
     * 假设条件是 <= 4
     * 1 2 3 3 4 4 4 5 5 6 7 8
     * ------------|
     */
    public static int binarySearchR(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left < right) {

            // 求右边界 mid 往右靠
            int mid = left + (right - left + 1) / 2;

            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }


    public static void main(String[] args) {

        int[] arr1 = new int[] {1, 2, 3 ,4, 5 ,6, 7, 8};
        int[] arr2 = new int[] {1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8};

        System.out.println(binarySearch(arr1, 4));
        System.out.println(binarySearchL(arr2, 4));
        System.out.println(binarySearchR(arr2, 4));
    }

}
