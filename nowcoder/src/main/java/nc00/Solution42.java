package nc00;

/*
题目描述
给出一组可能包含重复项的数字，返回该组数字的所有排列。
示例1
输入
复制
[1,1,2]
返回值
复制
[[1,1,2],[1,2,1],[2,1,1]]
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution42 {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

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

        HashSet<Integer> set = new HashSet<>();

        for (int i = index; i < num.length; i++) {
            if (!set.contains(num[i])) {
                set.add(num[i]);
                swap(num, index, i);
                dfs(num, index + 1, res);
                swap(num, index, i);
            }
        }

    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
