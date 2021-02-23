package nc00;

/*
给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
示例1
输入
复制
[2,3,4,5]
返回值
复制
4
示例2
输入
复制
[2,2,3,4,3]
返回值
复制
3
备注:
1 \leq n \leq 10^51≤n≤10
5
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution41 {

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here

        int l = 0, r = 0;
        int res = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < arr.length) {
            if (map.containsKey(arr[r]) && map.get(arr[r]) >= l) {
                l = map.get(arr[r]) + 1;
            }
            map.put(arr[r], r);
            r++;
            res = Math.max(res, r - l);
        }
        return res;
    }

}
