package nc00;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
示例1
输入
复制
1
返回值
复制
1
示例2
输入
复制
4
返回值
复制
5
 */

/**
 * @author zxy
 */
public class Solution68 {

    public int JumpFloor(int target) {

        if (target <= 2) {
            return target;
        }

        int[] dp = new int[target + 1];

        dp[1] = 1;
        dp[2] = 2;

        // 转移方程：dp[i] = dp[i - 1] + dp[i - 2];

        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[target];
    }

}
