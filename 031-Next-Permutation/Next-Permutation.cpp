/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/


/*
从后往前，找到一个比它后面的数小的数，让它与后面比它刚好大的数交换，再倒置它后面的所有数
特殊情况就是如果没找到，就直接倒置。
*/


class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        if(nums.size() <= 1) return;
        int lhs = nums.size() - 2, rhs = nums.size() - 1;
        while(lhs >= 0 && nums[lhs] >= nums[lhs + 1]) 
            lhs--;
        if(lhs < 0)
            reverse(nums.begin(), nums.end());
        else{
            while(nums[lhs] >= nums[rhs]) 
                rhs--;
            int temp = nums[lhs];
            nums[lhs] = nums[rhs];
            nums[rhs] = temp;
            sort(nums.begin() + 1 + lhs, nums.end());
        }
    }
};