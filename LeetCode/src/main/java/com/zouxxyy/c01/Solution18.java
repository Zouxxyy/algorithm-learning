package com.zouxxyy.c01;

/*
118. 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution18 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 0) {
            return res;
        }

        List<Integer> last = new ArrayList();
        last.add(1);
        res.add(last);

        for (int i = 1; i < numRows; i++) {

            List<Integer> cur = new ArrayList();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    cur.add(1);
                } else if (j == i) {
                    cur.add(1);
                } else {
                    cur.add(last.get(j - 1) + last.get(j));
                }
            }

            res.add(cur);
            last = cur;
        }

        return res;

    }

}
