package nc00;

/*
给定一个数组arr，返回子数组的最大累加和
例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
题目保证没有全为负数的数据
[要求]
时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)

示例1
输入
复制
[1, -2, 3, 5, -2, 6, -1]
返回值
复制
12
备注:
1 \leq N \leq 10^51≤N≤10
5

|arr_i| \leq 100∣arr
i
​
 ∣≤100
 */

/**
 * @author zxy
 */
public class Solution19 {

    /**
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray(int[] arr) {
        // write code here
        int res = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : arr) {

            if (sum < 0) {
                sum = 0;
            }

            sum += num;
            res = Math.max(sum, res);
        }

        return res;
    }

}
