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
        // dp[i][j] 表示 str1[0:i] 和 str[0:j]，以 i 和 j 结尾的最长公共字串
        // dp[i][j] = s1[i] == s2[i] ? 1 + dp[i - 1][j - 1] : 0

        int[][] dp = new int[str1.length()][str2.length()];

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int max = 0;
        int end = 0;

        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = 1 + ((i > 0 && j > 0) ? dp[i - 1][j - 1] : 0);
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                        end = i;
                    }
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);

    }
}
