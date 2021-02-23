package nc00;

/*
斐波那契数列

大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
n\leq 39n≤39

示例1
输入
复制
4
返回值
复制
3
 */

/**
 * @author zxy
 */
public class Solution65 {

    public int Fibonacci(int n) {

        int last = 0;
        int cur = 1;

        for (int i = 0; i < n; i++) {
            int temp = cur;
            cur += last;
            last = temp;
        }

        return last;
    }

}
