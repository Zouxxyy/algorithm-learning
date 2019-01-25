/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/




class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int i = 0; // start
        int max = 0;
        int j = 1; // end
        if(s.size() == 1)
            return 1;
        while(j < s.size()){
            for(int cmp = j - 1; cmp >= i; cmp--){
                if(s[cmp] == s[j])
                    i = cmp + 1;
            }
            int length = j - i + 1;
            if(length > max)
                max = length;
            j++;
        }
        return max;
    }
};