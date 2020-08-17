package com.zouxxyy.competition.c202;

/*
5489. 两球之间的磁力
在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。

已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。

给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。



示例 1：



输入：position = [1,2,3,4,7], m = 3
输出：3
解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
示例 2：

输入：position = [5,4,3,2,1,1000000000], m = 2
输出：999999999
解释：我们使用位于 1 和 1000000000 的篮子时最小磁力最大。


提示：

n == position.length
2 <= n <= 10^5
1 <= position[i] <= 10^9
所有 position 中的整数 互不相同 。
2 <= m <= position.length
 */

/*
思路：

这题吃亏了，以前没遇到过求最大最小值的问题，我知道这题肯定是先排序，然后我一直在想怎么划分。。完全没想到二分去。题目还是做少了呀
做这题学习一波二分模板，收获满满！！
 */

import java.util.Arrays;

/**
 * @author zxy
 */
public class Solution3 {

    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        // 通过二分找间隔的最大值

        // 计算左边界
        int l = Integer.MAX_VALUE;
        for (int i = 1; i < position.length; i++) {
            l = Math.min(position[i] - position[i - 1], l);
        }

        // 计算右边界
        int r = position[position.length - 1] - position[0];

        // 求最大，使用二分的右边界模板
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(position, m, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    /**
     * 是否可以取到 m 个点，且间隔 >= min
     */
    private boolean check(int[] position, int m, int min) {

        int last = position[0];

        for (int cur : position) {
            if ((cur - last) >= min) {
                if (--m == 1) {
                    return true;
                } else {
                    last = cur;
                }
            }
        }
        return false;
    }

}
