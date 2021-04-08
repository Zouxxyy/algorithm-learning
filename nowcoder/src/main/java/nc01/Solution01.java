package nc01;

/*
缺失数字

题目描述
从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小。

示例1
输入
[0,1,2,3,4,5,7]
返回值
6

示例2
输入
[0,2,3]
返回值
1
 */

/**
 * @author zxy
 */
public class Solution01 {

    /**
     * 找缺失数字
     *
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public int solve(int[] a) {
        // write code here

        // 0, 1, 2, 3, 4
        int n = a.length;
        int sum = (1 + n) * n / 2;
        for (int num : a) {
            sum -= num;
        }
        return sum;
    }

}
