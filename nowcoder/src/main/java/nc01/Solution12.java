package nc01;

/*
进制转换

给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
示例1
输入
复制
7,2
返回值
复制
"111"
备注:
M是32位整数，2<=N<=16.
 */

import java.util.Arrays;

/**
 * @author zxy
 */
public class Solution12 {

    /**
     * 进制转换
     *
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve(int M, int N) {
        // write code here
        StringBuilder sb = new StringBuilder();
        boolean positive = true;

        if (M == 0) {
            sb.append(0);
        } else if (M < 0) {
            positive = false;
            M = -M;
        }

        while (M > 0) {
            int num = M % N;
            if (num <= 9) {
                sb.append(num);
            } else {
                sb.append((char) (num - 10 + 'A'));
            }
            M /= N;
        }

        if (!positive) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }

}
