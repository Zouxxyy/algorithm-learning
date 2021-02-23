package nc00;

/*
编写一个函数来查找字符串数组中的最长公共前缀。
示例1
输入
复制
["abca","abc","abca","abc","abcc"]
返回值
复制
"abc"
 */

/**
 * @author zxy
 */
public class Solution55 {

    /**
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix(String[] strs) {
        // write code here

        StringBuilder sb = new StringBuilder();

        if (strs.length == 0) {
            return "";
        }

        int k = 0;
        while (k < strs[0].length()) {

            char cur = strs[0].charAt(k);

            for (int i = 1; i < strs.length; i++) {
                if (k >= strs[i].length() || strs[i].charAt(k) != cur) {
                    return sb.toString();
                }
            }

            sb.append(cur);
            k++;
        }

        return sb.toString();
    }

}
