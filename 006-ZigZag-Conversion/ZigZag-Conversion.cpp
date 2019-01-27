/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);

示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"

示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

*/




class Solution {
public:
    string convert(string s, int numRows) {
        int x = 2 * numRows - 2; // 一个常数
        string ret;
        int length = s.size();
        if(numRows == 1) return s;
        for(int m = 0; m < numRows; m++){                //m为行号
            for(int k = 0; k + m < length; k += x){      //k为第一行的字符的位置
                ret += s[k + m];
                if(m != 0 && m != numRows - 1 && k + x - m < length)
                    ret += s[k + x - m];
            }
        }
        return ret;            
    }
};
