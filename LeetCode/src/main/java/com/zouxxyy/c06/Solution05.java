package com.zouxxyy.c06;

/*
605. 种花问题
假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。



示例 1：

输入：flowerbed = [1,0,0,0,1], n = 1
输出：true
示例 2：

输入：flowerbed = [1,0,0,0,1], n = 2
输出：false


提示：

1 <= flowerbed.length <= 2 * 104
flowerbed[i] 为 0 或 1
flowerbed 中不存在相邻的两朵花
0 <= n <= flowerbed.length
 */

/**
 * @author zxy
 */
public class Solution05 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int cnt = 0;
        // 思路：计算两个 1 之间 0 的个数 zeros，然后可以种的花的个数为 (zeros - 1) / 2
        // 最左边隐含一个 0
        int zeros = 1;

        for (int planted : flowerbed) {

            if (planted == 1) {

                if (zeros != 0) {

                    cnt += (zeros - 1) / 2;
                    if (cnt >= n) {
                        return true;
                    }
                    zeros = 0;
                }

            } else {
                zeros += 1;
            }

        }

        // 最右边隐含一个 0
        return (cnt + zeros / 2) >= n;

    }

}
