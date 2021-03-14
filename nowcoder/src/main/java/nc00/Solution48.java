package nc00;

/*
在转动过的有序数组中寻找目标值

给出一个转动过的有序数组，你事先不知道该数组转动了多少
(例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
假设数组中不存在重复项。
示例1
输入
复制
[1],0
返回值
复制
-1
示例2
输入
复制
[3,2,1],1
返回值
复制
2
 */

/**
 * @author zxy
 */
public class Solution48 {

    /**
     * @param A      int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] A, int target) {
        // write code here

        int l = 0, r = A.length - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (A[mid] == target) {
                return mid;
            } else if (A[mid] >= A[l]) {
                if (target >= A[l] && target < A[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }

        return -1;
    }

}
