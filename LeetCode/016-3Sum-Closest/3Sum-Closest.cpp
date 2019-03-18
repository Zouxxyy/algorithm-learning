/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
*/


/*
固定第一个数，再用双指针处理两数和
*/


class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int ret = nums[0] + nums[1] + nums[2];
        for(int k = 0; k < nums.size() - 2; k++){
            int i = k + 1, j = nums.size() - 1;
            while(i < j){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target) 
                    j--;
                else if(sum < target) 
                    i++;
                else 
                    return target;
                if(abs(sum - target) < abs(ret - target))
                    ret = sum;
            }
        }
        return ret;
    }
};