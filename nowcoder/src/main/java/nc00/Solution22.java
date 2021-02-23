package nc00;

/*
给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
注意：
可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和
 */

/**
 * @author zxy
 */
public class Solution22 {

    public void merge(int A[], int m, int B[], int n) {

        int i = m - 1, j = n - 1;

        // 倒序添加
        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0) {
                A[k] = B[j--];
            } else if (j < 0) {
                A[k] = A[i--];
            } else if (A[i] >= B[j]) {
                A[k] = A[i--];
            } else {
                A[k] = B[j--];
            }
        }

    }

}
