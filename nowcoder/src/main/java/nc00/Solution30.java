package nc00;

/*
数组中未出现的最小正整数

题目描述
给定一个无序数组arr，找到数组中未出现的最小正整数
例如arr = [-1, 2, 3, 4]。返回1
arr = [1, 2, 3, 4]。返回5
[要求]
时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)

示例1
输入
复制
[-1,2,3,4]
返回值
复制
1
备注:
1 \leq N \leq 10^61≤N≤10
6

|arr_i| \leq 10^9∣arr
i
​
 ∣≤10
9
 */

/**
 * @author zxy
 */
public class Solution30 {

    /**
     * return the min number
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberdisappered(int[] arr) {
        // write code here

        for (int num : arr) {
            if (num >= 1 && num <= arr.length) {
                arr[num - 1] = num;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i + 1 != arr[i]) {
                return i + 1;
            }
        }

        return arr.length + 1;
    }

}
