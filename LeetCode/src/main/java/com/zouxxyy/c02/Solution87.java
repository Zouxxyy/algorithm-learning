package com.zouxxyy.c02;

/*
287. 寻找重复数
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:

输入: [1,3,4,2,2]
输出: 2
示例 2:

输入: [3,1,3,4,2]
输出: 3
说明：

不能更改原数组（假设数组是只读的）。
只能使用额外的 O(1) 的空间。
时间复杂度小于 O(n2) 。
数组中只有一个重复的数字，但它可能不止重复出现一次。
 */

/*
思路：

不看题解，想不出满足条件的解法。官方解法有两种：
二分查找：二分查找需要在有序环境下，可是题目要求只能使用O(1)，因此每次计算时生成新数，也是人才
快慢指针法：把数组看出链表，arr[i] 是下个指针的 index。解法参见 142. 环形链表 II

 */


/**
 * @author zxy
 */
public class Solution87 {

    public int findDuplicate(int[] nums) {

        // 注意快慢指针在 nums[0] = 0 时失效，可以题目不允许 nums[0] = 0 ，因此没问题

        int fast = nums[0];
        int slow = nums[0];

        // 1 找交点
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        // 2 头移动相同步数环入口相遇
        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }

}
