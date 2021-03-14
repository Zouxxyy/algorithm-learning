package nc00;

/*
数组中只出现一次的两个数字

一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
示例1
输入
复制
[1,4,1,6]
返回值
复制
[4,6]
说明
返回的结果中较小的数排在前面
 */

/**
 * @author zxy
 */
public class Solution75 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce(int[] array) {
        // write code here

        // x ^ 0 =, x ^ x = 0
        int x = 0;
        for (int num : array) {
            x ^= num;
        }

        // 分组
        int div = 1;
        while ((div & x) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int num : array) {
            if ((num & div) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return a <= b ? new int[]{a, b} : new int[]{b, a};
    }

}
