/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
*/


/*
回溯思想
*/

class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if(digits.length() == 0) return ret;
        ReLetterCombinations("", digits);
        return ret;
    }
    
    void ReLetterCombinations(string prefix, string rest){
        if(rest.size()==0) 
            ret.push_back(prefix);
        else
            for(char opt: letters[rest[0] - '2'])
                ReLetterCombinations(prefix + opt, rest.substr(1));
    }
    
private:
    vector<string> letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
    vector<string> ret;
};