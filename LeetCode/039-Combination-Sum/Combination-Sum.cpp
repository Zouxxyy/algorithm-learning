/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/


/*
回溯算法，这是我能想出最简单的了，可排名依旧很低
*/


class Solution {
public:
    vector<vector<int>> result;
    vector<int> ret;
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        recombinationSum(candidates, target, 0);
        return result;
    }
    
    void recombinationSum(vector<int>& candidates, int target, int i){
        if(target == 0){
            result.push_back(ret);
            return;
        }
        if(i == candidates.size() || candidates[i] > target) 
            return;
        else{
            ret.push_back(candidates[i]);
            recombinationSum(candidates, target - candidates[i], i);
            ret.pop_back();
        }
        recombinationSum(candidates, target, i + 1);
    }
};