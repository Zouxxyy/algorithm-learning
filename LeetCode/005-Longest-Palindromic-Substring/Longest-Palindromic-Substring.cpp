/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
*/


/*
我的解法：
遍历，再套bias循环,空间复杂度o(1)
*/


class Solution {
public:
    string longestPalindrome(string s) {
        int length = 0;
        int start, bias;  
        if(s.size() <= 1)
            return s;
        for(int i = 0; i < s.size(); i++){
            //找奇数回文
            for(bias = 0; (i - bias) >= 0 && (i + bias) < s.size(); bias++){
                if(s[i - bias] != s[i + bias])
                    break;
            }
            if(2 * bias - 1 > length){
                length = 2 * bias - 1;
                start = i - bias + 1;
            }
            //找偶数回文
            for(bias = 0; (i - bias) >= 0 && (i + bias + 1) < s.size(); bias++){
                if(s[i - bias] != s[i + 1 + bias])
                    break;
            }
            if(2 * bias > length){
                length = 2 * bias;
                start = i - bias + 1;
            }
        }
        return s.substr(start,length); 
    }
};