package nc01;

/*
最长公共子串

给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
示例1
输入
复制
"1AB2345CD","12345EF"
返回值
复制
"2345"
备注:
1 \leq |str_1|, |str_2| \leq 5\,0001≤∣str
1
​
 ∣,∣str
2
​
 ∣≤5000
 */

/**
 * @author zxy
 */
public class Solution27 {

    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        // write code here
        // dp[i][j]: str1[i:] 和 str2[j:] 的最长公共子串
        // 转移方程：dp[i][j] = str1[i] == str2[j] ? dp[i + 1][j + 1] + 1 : 0

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int n1 = chars1.length, n2 = chars2.length;
        int maxLength = 0, start = 0;
        int[][] dp = new int[n1][n2];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {

                dp[i][j] = chars1[i] == chars2[j] ? ((i + 1 < n1 && j + 1 < n2) ? dp[i + 1][j + 1] : 0) + 1 : 0;

                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                    start = i;
                }
            }
        }

        if (maxLength == 0) {
            return "-1";
        } else {
            return str1.substring(start, start + maxLength);
        }
    }

}
