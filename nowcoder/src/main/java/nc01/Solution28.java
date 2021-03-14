package nc01;

/*
容器盛水问题

给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
示例1
输入
复制
[3,1,2,5,2,4]
返回值
复制
5
说明
数组长度≤
示例2
输入
复制
[4,5,1,3,2]
返回值
复制
2
说明
数组长度\leq 10^6数组长度≤10
6

备注:
1 \leq N \leq 10^61≤N≤10
6
 */

/**
 * @author zxy
 */
public class Solution28 {

    /**
     * max water
     *
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater(int[] arr) {

        int maxL = 0, maxR = 0;
        long res = 0;
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            if (maxL < maxR) {
                if (maxL <= arr[l]) {
                    maxL = arr[l];
                } else {
                    res += maxL - arr[l];
                }
                l++;
            } else {
                if (maxR <= arr[r]) {
                    maxR = arr[r];
                } else {
                    res += maxR - arr[r];
                }
                r--;
            }
        }

        return res;
    }

}
