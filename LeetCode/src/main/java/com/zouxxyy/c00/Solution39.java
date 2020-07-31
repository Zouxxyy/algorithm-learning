package com.zouxxyy.c00;

/*
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
 */

/*
思路：

先排序，再回溯
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zxy
 */
public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> res = new LinkedList<>();

        dfs(candidates, target, res, new LinkedList<>(), 0);

        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> cur, int index) {

        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // 剪枝
            if (candidates[i] > target) {
                return;
            }

            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], res, cur, i);
            cur.removeLast();

        }
    }

}
