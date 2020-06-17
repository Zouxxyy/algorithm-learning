/*
面试题57 - II. 和为s的连续正数序列

输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 

限制：

1 <= target <= 10^5
 */

package com.zouxxyy;

import java.util.LinkedList;

public class Solution57_2 {
    public int[][] findContinuousSequence(int target) {

        LinkedList<int[]> lists = new LinkedList<>();
        for (int i = (target + 1) / 2; i >= 2; i--) {
            // 9 = 2 + 3 + 4
            if (target % i == 0 && i % 2 == 1 && (target / i - (i - 1) / 2) >= 1) {
                int[] array = new int[i];
                array[0] = target / i - (i - 1) / 2;
                for (int j = 1; j < i; j++) {
                    array[j] = array[j - 1] + 1;
                }
                lists.add(array);
            }
            // 9 = 4 + 5
            if (target % i != 0 && target * 2 % i == 0 && i % 2 == 0 && (target / i - i / 2 + 1) >= 1) {
                int[] array = new int[i];
                array[0] = target / i - i / 2 + 1;
                for (int j = 1; j < i; j++) {
                    array[j] = array[j - 1] + 1;
                }
                lists.add(array);
            }
        }
        return lists.toArray(new int[0][]);
    }
}
