package com.zouxxxyy.search;

/*
二分查找

仅适用顺序表的查找！

时间复杂度：O(logn)
空间复杂度：O(1)

单个数满足条件：while(l <= r)

多个数满足条件：

找大于等于给定数的第一个位置，满足某个条件的第一个数（求最小值，左边界问题）

    while (l < r) {
        int mid = l + (r - l) / 2;
        if (check()) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }
    return l;

找小于等于给定数的第一个位置，满足某个条件的第一个数（求最大值，右边界问题）

    while (l < r) {
        int mid = l + (r - l + 1) / 2;
        if (check()) {
            l = mid;
        } else {
            r = mid - 1;
        }
    }
    return l;

记忆：while(l < r)，哪个边界中点哪边靠，先写 uncheck 条件分支，check 分支 mid 不变，return l

特别注意：如果最后算出来的坐标，回到了 l 或者 r 的初始值，此时不一定满足条件，也就 check(x) 不一定为 true！！
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

            // 左边界往左靠
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

            // 右边界往右靠
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
