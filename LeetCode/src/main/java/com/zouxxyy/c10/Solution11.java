package com.zouxxyy.c10;

/*
1011. 在 D 天内送达包裹的能力
传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。

传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。

返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。



示例 1：

输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
输出：15
解释：
船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
第 1 天：1, 2, 3, 4, 5
第 2 天：6, 7
第 3 天：8
第 4 天：9
第 5 天：10

请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
示例 2：

输入：weights = [3,2,2,4,1,4], D = 3
输出：6
解释：
船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
第 1 天：3, 2
第 2 天：2, 4
第 3 天：1, 4
示例 3：

输入：weights = [1,2,3,1,1], D = 4
输出：3
解释：
第 1 天：1
第 2 天：2
第 3 天：3
第 4 天：1, 1


提示：

1 <= D <= weights.length <= 50000
1 <= weights[i] <= 500
 */

/**
 * @author zxy
 */
public class Solution11 {

    public int shipWithinDays(int[] weights, int D) {

        // 最大最小值问题，求最小值，用二分左边界模板
        // l 取 weights 最大值，r 取 weights 总和

        int l = 0, r = 0;
        for (int weight : weights) {
            l = Math.max(l, weight);
            r += weight;
        }

        while (l < r) {

            int mid = l + (r - l) / 2;
            if (can(weights, mid, D)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean can(int[] weights, int cur, int D) {

        int res = 0, sum = 0;

        for (int weight : weights) {
            if (sum + weight <= cur) {
                sum += weight;
            } else {
                if (++res > D) {
                    return false;
                }
                sum = weight;
            }
        }

        return sum == 0 || ++res <= D;
    }
}
