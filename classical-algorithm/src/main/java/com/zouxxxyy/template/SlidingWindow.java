package com.zouxxxyy.template;

/*
滑动窗口模板

记忆：窗口左闭右开，都从0开始，while（r < length）：添加arr[r]，r++ while(check) 移除 arr[l]，l++

注意：该模板会无条件添加第一个数进入窗口内，切记！
 */

/**
 * @author zxy
 */
public class SlidingWindow {

    public void Solution(String[] args) {

        // 目标数组
        int[] arr = new int[]{1, 2, 3, 4, 5};

        // 窗口左右边界，左闭右开
        int l = 0, r = 0;

        while (r < arr.length) {

            // ...
            // 窗口加入 arr[r]，执行相应逻辑
            // ...

            r++;

            // 循环检查，右移 l
            while (check()) {

                // ...
                // 窗口移除 arr[l]，执行相应逻辑
                // ...

                l++;

            }

        }

    }


    /**
     * 窗口是否符合题目给的条件
     */
    private boolean check() {
        return true;
    }


}
