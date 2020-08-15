package com.zouxxyy.c02;

/*
207. 课程表
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？



示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。


提示：

输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <= numCourses <= 10^5
 */

/*
思路：

广搜；由可学习课程出发，找出可学习的课程，因此构建结构[前置课程][课程列表]（用于找可学习课程），每个课程的依赖个数（用于判断是否可学习）
 */


import java.util.*;

/**
 * @author zxy
 */
public class Solution07 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 2维列表 [前置课程][课程列表]
        List<List<Integer>> deps = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            deps.add(new ArrayList<>());
        }

        // 数组: index是课程ID，值是该课程的前置课程个数
        int[] depCounts = new int[numCourses];

        // 填好前面两个结构
        for (int[] prerequisite : prerequisites) {
            depCounts[prerequisite[0]]++;
            deps.get(prerequisite[1]).add(prerequisite[0]);
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < depCounts.length; i++) {
            if (depCounts[i] == 0) {
                queue.addLast(i);
            }
        }

        int canLearnCount = 0;

        while (!queue.isEmpty()) {

            canLearnCount++;

            // 找到完成的课程的后置课程，让其依赖个数减1
            for (Integer index : deps.get(queue.poll())) {
                depCounts[index]--;
                if (depCounts[index] == 0) {
                    queue.addLast(index);
                }
            }
        }

        return canLearnCount == numCourses;
    }

}
