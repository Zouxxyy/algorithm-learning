/*
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。


示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49
*/


class Solution {
public:
    int maxArea(vector<int>& height) {
        /*
        //暴力法
        int ret = 0;
        int n = height.size();
        for(int i = 0; i < n -1; i++){
            int j = i + 1;
            while(j < n){
                int y = height[i] < height[j] ? height[i] : height[j];
                if(ret < y * (j - i))
                    ret = y * (j - i);
                j++;
            }
        }
        return ret;
        */
        
        //双指针
        int ret = 0;
        int i = 0;
        int y = 0;
        int j = height.size() - 1;
        while(i < j){
            if(height[i] > height[j])
                y = height[j--];
            else
                y = height[i++];
            if(ret < y * (j - i + 1))
                ret = y * (j - i + 1);
        }
        return ret;
    }
};