package nc00;

import java.util.*;

/*
没有重复项数字的所有排列

题目描述
给出一组数字，返回该组数字的所有排列
例如：
[1,2,3]的所有排列如下
[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
（以数字在数组中的位置靠前为优先级，按字典序排列输出。）

示例1
输入
[1,2,3]
返回值
[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

/**
 * @author zxy
 */
public class Solution43 {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(num, 0, res);
        return res;
    }

    private void dfs(int[] num, int index, ArrayList<ArrayList<Integer>> res) {

        if (index == num.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : num) {
                list.add(i);
            }
            res.add(list);
            return;
        }

        for (int i = index; i < num.length; i++) {
            swap(num, index, i);
            dfs(num, index + 1, res);
            swap(num, index, i);
        }

    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
