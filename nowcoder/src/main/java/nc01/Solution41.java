package nc01;

/*
判断回文

给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
示例1
输入
复制
"absba"
返回值
复制
true
示例2
输入
复制
"ranko"
返回值
复制
false
示例3
输入
复制
"yamatomaya"
返回值
复制
false
示例4
输入
复制
"a"
返回值
复制
true
备注:
字符串长度不大于1000000，且仅由小写字母组成
 */

/**
 * @author zxy
 */
public class Solution41 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge(String str) {
        // write code here

        char[] chars = str.toCharArray();
        int l = 0, r = chars.length - 1;

        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

}
