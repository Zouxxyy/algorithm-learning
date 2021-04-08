package nc00;

/*
题目描述
给出一组候选数\ C C 和一个目标数\ T T，找出候选数中起来和等于\ T T 的所有组合。
\ C C 中的每个数字在一个组合中只能使用一次。
注意：
题目中所有的数字（包括目标数\ T T ）都是正整数

结果中不能包含重复的组合
组合之间的排序按照索引从小到大依次比较，小的排在前面，如果索引相同的情况下数值相同，则比较下一个索引。
示例1
输入
复制
[100,10,20,70,60,10,50],80
返回值
复制
[[10,10,60],[10,20,50],[10,70],[20,60]]
说明
给定的候选数集是[100,10,20,70,60,10,50]，目标数是80
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution46 {

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {


        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(num, target, 0, res, new ArrayList<>());
        return res;

    }

    private void dfs(int[] num, int target, int index, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur) {

        if (target == 0) {
            res.add(new ArrayList<>(cur));
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < num.length; i++) {
            if (i == index || num[i] != num[i - 1]) {

                cur.add(num[i]);
                dfs(num, target - num[i], i + 1, res, cur);
                cur.remove(cur.size() - 1);
            }
        }

    }

}
