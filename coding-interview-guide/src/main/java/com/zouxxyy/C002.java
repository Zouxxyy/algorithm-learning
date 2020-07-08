package com.zouxxyy;

import java.util.Arrays;
import java.util.Scanner;

/*
题目描述
先给出可整合数组的定义：如果一个数组在排序之后，每相邻两个数的差的绝对值都为1，或者该数组长度为1，则该数组为可整合数组。
例如，[5, 3, 4, 6, 2]排序后为[2, 3, 4, 5, 6]，符合每相邻两个数差的绝对值都为1，所以这个数组为可整合数组
给定一个数组arr, 请返回其中最大可整合子数组的长度。例如，[5, 5, 3, 2, 6, 4, 3]的最大可整合子数组为[5, 3, 2, 6, 4]，所以请返回5
[要求]
时间复杂度为O(n^2)，空间复杂度为O(n)
输入描述:
第一行一个整数N，表示数组长度
第二行N个整数，分别表示数组内的元素
输出描述:
输出一个整数，表示最大可整合子数组的长度
 */

/*
注意：题目并没有要求子数组是连续的

思路：
排序 + dp
时间复杂度为O(nlogn) (快排)，空间复杂度为O(1)
 */

/**
 * @author zxy
 */
public class C002 {

    public static int solution(int[] array) {

        final int size = array.length;
        if (size <= 1) {
            return size;
        }

        Arrays.sort(array);
        int max = 1;
        // 挨着滑动指针的组合的最大值
        int cur = 1;

        for (int i = 1; i < size; i++) {
            if (array[i] == (array[i - 1] + 1)) {
                if (++cur > max) {
                    max = cur;
                }
            // array[i] == array[i - 1]时 直接 continue
            } else if (array[i] != array[i - 1]) {
                cur = 1;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int size = sc.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(array));
    }
}
