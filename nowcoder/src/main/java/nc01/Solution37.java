package nc01;

import java.util.*;

/**
 * @author zxy
 */
public class Solution37 {

    public int solve(String s) {
        // write code here

        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> opts = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>(4);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {

            if (cs[i] == '(') {
                opts.push(cs[i]);
            } else if (cs[i] == ')') {
                while (opts.peek() != '(') {
                    cal(nums, opts);
                }
                opts.pop();
            } else if (cs[i] >= '0' && cs[i] <= '9') {
                int sum = 0;
                int j = i;
                while (j < cs.length && cs[j] >= '0' && cs[j] <= '9') {
                    sum = sum * 10 + cs[j] - '0';
                    j++;
                }
                i = j - 1;
                nums.push(sum);
            } else {
                while (!opts.isEmpty() && opts.peek() != '(' && map.get(opts.peek()) >= map.get(cs[i])) {
                    cal(nums, opts);
                }
                opts.push(cs[i]);
            }
        }
        while (!opts.isEmpty()) {
            cal(nums, opts);
        }
        return nums.pop();
    }

    private void cal(LinkedList<Integer> nums, LinkedList<Character> opts) {

        int y = nums.pop();
        int x = nums.pop();
        int res;
        char opt = opts.pop();

        if (opt == '+') {
            res = x + y;
        } else if (opt == '-') {
            res = x - y;
        } else if (opt == '*') {
            res = x * y;
        } else {
            res = x / y;
        }

        nums.push(res);
    }

}
