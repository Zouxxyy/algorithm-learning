package nc00;

/*
有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。

给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。

示例1
输入
复制
[1,3,5,2,2],5,3
返回值
复制
2
 */

/**
 * @author zxy
 */
public class Solution88 {


    public int findKth(int[] a, int n, int K) {
        // write code here
        int l = 0, r = n - 1;
        K = n - K;

        while (l <= r) {
            int s = getSplitIndex(a, l, r);
            if (s == K) {
                return a[s];
            } else if (s < K) {
                l = s + 1;
            } else {
                r = s - 1;
            }
        }

        return a[l];
    }


    private int getSplitIndex(int[] arr, int l, int r) {

        // 把最左边的数做分割点
        int split = arr[l];

        while (l < r) {
            // 从右向左找第一个小于x的数
            while (l < r && arr[r] >= split) {
                r--;
            }
            if (l < r) {
                arr[l++] = arr[r];
            }

            // 从左向右找第一个大于等于x的数
            while (l < r && arr[l] < split) {
                l++;
            }
            if (l < r) {
                arr[r--] = arr[l];
            }
        }
        arr[l] = split;
        return l;
    }

}
