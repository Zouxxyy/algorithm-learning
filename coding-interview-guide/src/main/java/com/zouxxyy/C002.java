package com.zouxxyy;

import java.util.Arrays;
import java.util.Scanner;

/*
题目并没有要求子数组是连续的
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
