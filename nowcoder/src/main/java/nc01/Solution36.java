package nc01;


/*
题目描述
请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图

示例1
输入
复制
[1,2,4,5,3],[4,2,5,1,3]
返回值
复制
[1,3,5]
备注:
二叉树每个节点的值在区间[1,10000]内，且保证每个节点的值互不相同。
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution36 {

    public int[] solve(int[] xianxu, int[] zhongxu) {

        ArrayList<Integer> list = new ArrayList<>();
        dfs(xianxu, zhongxu, 0, xianxu.length - 1, 0, zhongxu.length - 1, 0, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(int[] xianxu, int[] zhongxu, int lS, int lE, int rS, int rE, int level, ArrayList<Integer> list) {

        if (lS > lE) {
            return;
        }

        int root = xianxu[lS];
        if (list.size() == level) {
            list.add(root);
        } else {
            list.set(level, root);
        }

        int split = rS;
        while (zhongxu[split] != root) {
            split++;
        }

        dfs(xianxu, zhongxu, lS + 1, split + lS - rS, rS, split - 1, level + 1, list);
        dfs(xianxu, zhongxu, split + lS - rS + 1, lE, split + 1, rE, level + 1, list);
    }

}
