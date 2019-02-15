/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
*/


class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ret;
        if(strs.size() == 0)
            return ret;
        int n = strs[0].size(); //计算字符串的最小长度
        for(int i = 0; i < strs.size(); i++){
            if(n > strs[i].size())
                n = strs[i].size();
        }
        for(int i = 0; i < n; i++){
            char letter = strs[0][i];
            bool flag = true;
            for(int j = 0; j < strs.size(); j++){
                if(letter != strs[j][i]){
                    flag = false;
                    break;
                }     
            }
            if(flag == true)
                ret += letter;
            else
                break;
        }    
        return ret;
    }
};