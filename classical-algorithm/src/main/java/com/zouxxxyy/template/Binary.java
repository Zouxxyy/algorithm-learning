package com.zouxxxyy.template;


/*
二分模板

仅适用顺序表的查找！

记忆：while(l < r)，哪个边界中点哪边靠，先写 uncheck 条件分支（因为它好判断），check 分支 mid 不变，return l

特别注意：如果最后算出来的坐标，回到了 l 或者 r 的初始值，此时不一定满足条件，也就 check(x) 不一定为 true！！
 */


/**
 * @author zxy
 */
public class Binary {

    // 只有一个数满足条件

    /**
     * eg. 求满足条件的数的 index
     */
    public int binarySearch() {

        // 目标数组
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int l = 0, r = arr.length - 1;

        int target = 4;
        // 注意是 <=
        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }


    // 多个数满足条件，通常用于求极值问题

    /**
     * 找大于等于给定数的第一个位置，满足某个条件的第一个数（求最小值，左边界问题）
     * <p>
     * eg. 假设条件是 >= 4
     * 1 2 3 3 4 4 4 5 5 6 7 8
     *         | -------------
     */
    public int binarySearchL() {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int left = 0, right = arr.length - 1;

        while (left < right) {

            // 求左边界 mid 往左靠
            int mid = left + (right - left) / 2;

            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 找小于等于给定数的第一个位置，满足某个条件的第一个数（求最大值，右边界问题）
     * <p>
     * eg. 假设条件是 <= 4
     * 1 2 3 3 4 4 4 5 5 6 7 8
     * ------------|
     */
    public int binarySearchR() {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int left = 0, right = arr.length - 1;

        while (left < right) {

            // 求右边界 mid 往右靠
            int mid = left + (right - left + 1) / 2;

            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }


    /**
     * 是否符合条件
     */
    private boolean check(int mid) {
        return true;
    }


}
