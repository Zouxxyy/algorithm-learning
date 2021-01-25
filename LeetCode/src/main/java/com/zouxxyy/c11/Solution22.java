package com.zouxxyy.c11;

/*
1122. 数组的相对排序
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。



示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]


提示：

1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution22 {

    public int[] relativeSortArrayOld(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : arr1) {
            list.add(num);
        }

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        // 2 重排序，第一重：如果数在 arr2 中，值为 index，否则为 1001
        list.sort((o1, o2) -> {
            if (map.containsKey(o1) || map.containsKey(o2)) {
                return map.getOrDefault(o1, 1001) - map.getOrDefault(o2, 1001);
            }
            return o1 - o2;
        });

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }

        return arr1;
    }


    /**
     * 计数排序
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int max = 0;
        for (int num : arr1) {
            max = Math.max(max, num);
        }

        // 计数排序数组
        int[] nums = new int[max + 1];

        for (int num : arr1) {
            nums[num]++;
        }

        int i = 0;

        // 先添加在 arr2 中的数
        for (int num : arr2) {
            for (int c = 0; c < nums[num]; c++) {
                arr1[i++] = num;
            }
            // 已经添加，所以个数置 0
            nums[num] = 0;
        }

        // 再添加剩下的数
        for (int num = 0; num < nums.length; num++) {
            for (int c = 0; c < nums[num]; c++) {
                arr1[i++] = num;
            }
        }

        return arr1;
    }

}
