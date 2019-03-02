/*
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/


/*
回溯算法
*/


class Solution {
    private List<String> ret = new ArrayList<String>();
    
    public List<String> generateParenthesis(int n) {
        recall("", 0, 0, n);
        return ret;
    }
    
    void recall(String cur, int i, int j, int n) {
        if(j == n){
            ret.add(cur);
            return;
        }
        if(i != n) recall(cur + '(', i + 1, j, n);
        if(i > j) recall(cur + ')', i, j + 1, n);
    }
}