package nc00;

/*
最小编辑代价

题目描述
给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。

示例1
输入
"abc","adc",5,3,2
返回值
2

示例2
输入
"abc","adc",5,3,100
返回值
8


 */

/**
 * @author zxy
 */
public class Solution35 {

    public int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        // write code here

        // dp[i][j] 表示 s1[0:i - 1] 到 s2[0:j - 1] 的最小代价
        // s1[i - 1] == s2[j - 1] ->  dp[i][j] = dp[i - 1][j - 1]
        // s1[i - 1] != s2[j - 1] ->  dp[i][j] = min(dp[i - 1][j - 1] + rc, dp[i][j - 1] + ic, dp[i - 1][j] + dc);

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i <= s1.length; i++) {
            dp[i][0] = i * dc;
        }
        for (int j = 1; j <= s2.length; j++) {
            dp[0][j] = j * ic;
        }

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(rc + dp[i - 1][j - 1], dc + dp[i - 1][j]), ic + dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }

}
