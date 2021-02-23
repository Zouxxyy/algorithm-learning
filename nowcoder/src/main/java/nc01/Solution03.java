package nc01;

/*
反转字符串

写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
示例1
输入
复制
"abcd"
返回值
复制
"dcba"
 */

/**
 * @author zxy
 */
public class Solution03 {

    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve(String str) {
        // write code here

        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

}
