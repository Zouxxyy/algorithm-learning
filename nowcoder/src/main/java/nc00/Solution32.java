package nc00;

/*
求平方根

实现函数 int sqrt(int x).
计算并返回x的平方根（向下取整）
示例1
输入
复制
2
返回值
复制
1
 */

/**
 * @author zxy
 */
public class Solution32 {

    /**
     * @param x int整型
     * @return int整型
     */
    public int sqrt(int x) {
        // write code here

        int l = 0, r = x;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (mid <= x / mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

}
