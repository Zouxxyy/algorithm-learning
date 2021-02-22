package nc00;

/*
题目描述
以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
（字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
示例1
输入
复制
"1","99"
返回值
复制
"100"
说明
1+99=100
 */

/**
 * @author zxy
 */
public class Solution01 {

    public String solve(String s, String t) {

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = cs.length - 1, j = ct.length - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;
            if (i >= 0) {
                sum += cs[i] - '0';
                i--;
            }

            if (j >= 0) {
                sum += ct[j] - '0';
                j--;
            }

            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();

    }
}
