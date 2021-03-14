package nc00;

/*
最长回文子串

对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。

给定字符串A以及它的长度n，请返回最长回文子串的长度。

示例1
输入
复制
"abc1234321ab",12
返回值
复制
 */

/**
 * @author zxy
 */
public class Solution17 {

    public int getLongestPalindrome(String A, int n) {

        // write code here
        // dp[i][j] = A[i] == A[j] && (j - i < 3 || dp[i + 1][j - 1])

        char[] chars = A.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = chars[i] == chars[j] && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

}
