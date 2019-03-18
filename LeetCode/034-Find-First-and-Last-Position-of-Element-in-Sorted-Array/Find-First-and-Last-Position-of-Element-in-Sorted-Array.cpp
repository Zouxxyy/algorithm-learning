/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
*/


/*
2个2分法，一个找左边界，一个找右边界
*/


class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int l = 0, r = nums.size() - 1;
        vector<int> ret;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target)){
                ret.push_back(mid);
                break;
            }
            if(nums[mid] >= target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        if(ret.size() == 0) return {-1, -1};
        l = ret[0], r = nums.size() - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target && (mid == (nums.size() - 1) || nums[mid + 1] != target)){
                ret.push_back(mid);
                break;
            }
            if(nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return ret;
    }
};