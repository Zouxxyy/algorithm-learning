package com.zouxxyy.competition.b034;

/**
 * @author zxy
 */
public class Solution2 {

    private static final int MOD  = 1000000007;

    public int numWays(String s) {

        int count = 0;
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '1') {
                count++;
            }
        }

        if (count % 3 != 0) {
            return 0;
        }

        if (count == 0) {

            int res = 0;

            for (int i = 1; i <= chars.length - 2; i++) {
                res += i;
                res %= MOD;
            }
            return res;
        }

        int c = 0;
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '1') {
                c++;
                if (c == count / 3) {
                    l1 = i + 1;
                    break;
                }
            }
        }

        for (int i = l1; i < chars.length; i++) {
            if (chars[i] == '1') {
                r1 = i - 1;
                break;
            }
        }

        c = 0;
        for (int i = chars.length - 1; i >= 0; i--) {

            if (chars[i] == '1') {
                c++;
                if (c == count / 3) {
                    r2 = i - 1;
                    break;
                }
            }
        }

        for (int i = r2; i >= 0; i--) {
            if (chars[i] == '1') {
                l2 = i + 1;
                break;
            }
        }

        int c1 = r1 - l1 + 1;
        int c2 = r2 - l2 + 1;

        return (int) (((long) c1 + 1) % MOD * ((long) c2 + 1) % MOD);

    }

    public static void main(String[] args) {
        new Solution2().numWays("100100010100110");
    }
}
