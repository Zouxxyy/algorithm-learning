/*
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/


class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> res;
        int n = nums.size();
        if(n < 4) return res;
        sort(nums.begin(), nums.end());
        for(int k1 = 0; k1 < n - 3; k1++){
            if(nums[k1] + nums[k1 + 1] + nums[k1 + 2] + nums[k1 + 3] > target) break;  
            if(nums[k1] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
            if(k1 > 0 && nums[k1] == nums[k1 - 1]) continue;
            for(int k2 = k1 + 1; k2 < n - 2; k2++){
                if(nums[k1] + nums[k2] + nums[k2 + 1] + nums[k2 + 2] > target) break;
                if(nums[k1] + nums[k2] + nums[n - 2] + nums[n - 1] < target) continue;
                if(k2 != (k1 + 1) && nums[k2] == nums[k2 -1]) continue;
                int twosum = target - nums[k1] - nums[k2];
                int i = k2 + 1, j = n - 1;
                while (i < j) {
                    if (nums[i] + nums[j] == twosum) {
                        res.push_back({nums[k1], nums[k2], nums[i], nums[j]});
                        while (i < j && nums[i] == nums[i + 1]) ++i;
                        while (i < j && nums[j] == nums[j - 1]) --j;
                        ++i; --j;
                    } else if (nums[i] + nums[j] < twosum) ++i;
                    else --j;
                }
            }
        }
        return res;
    }
};