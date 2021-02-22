package nc01;

/*
题目描述
请实现有重复数字的升序数组的二分查找。
输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
示例1
输入
复制
5,4,[1,2,4,4,5]
返回值
复制
3
说明
输出位置从1开始计算
 */

/**
 * @author zxy
 */
public class Solution05 {

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        // write code here
        if (a[n - 1] < v) {
            return n + 1;
        }

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] >= v) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }

}
