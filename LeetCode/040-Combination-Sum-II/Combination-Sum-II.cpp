/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
*/


/*
在39题上修改一点就行
*/


class Solution {
public:
    vector<vector<int>> result;
    vector<int> ret;
    
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        recombinationSum2(candidates, target, 0);
        return result;
    }
    
    void recombinationSum2(vector<int>& candidates, int target, int i){
        if(target == 0){
            result.push_back(ret);
            return;
        }
        if(i == candidates.size() || candidates[i] > target) 
            return;
        else{
            ret.push_back(candidates[i]);
            recombinationSum2(candidates, target - candidates[i], i + 1); //加入当前的数
            ret.pop_back();
        }
        while(i + 1 != candidates.size() && candidates[i] == candidates[i + 1])
            i++;
        recombinationSum2(candidates, target, i + 1); //不加入当前的数
    }
};