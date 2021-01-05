package com.zouxxyy.competition.b034;

/**
 * @author zxy
 */
public class Solution3 {

    public int findLengthOfShortestSubarray(int[] arr) {

        if (arr.length <= 1) {
            return 0;
        }

        int l = 0, r = arr.length - 1;

        int res = Integer.MAX_VALUE;

        boolean move = true;

        while (l < r && arr[l] <= arr[r] && move) {

            move = false;

            while (l + 1 < r && arr[l + 1] >= arr[l] && arr[l + 1] <= arr[r]) {
                move = true;
                l++;
            }

            while (r - 1 > l && arr[r - 1] <= arr[r] && arr[l] <= arr[r - 1]) {
                move = true;
                r--;
            }
        }

        res = Math.min(res, r - l - 1 + (arr[l] <= arr[r] ? 0 : 1));


        l = 0; r = arr.length - 1;
        move = true;
        while (l < r && arr[l] <= arr[r] && move) {

            move = false;

            while (r - 1 > l && arr[r - 1] <= arr[r] && arr[l] <= arr[r - 1]) {
                move = true;
                r--;
            }

            while (l + 1 < r && arr[l + 1] >= arr[l] && arr[l + 1] <= arr[r]) {
                move = true;
                l++;
            }
        }

        res = Math.min(res, r - l - 1 + (arr[l] <= arr[r] ? 0 : 1));

        int i;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                break;
            }
        }
        res = Math.min(res, arr.length - i);

        for (i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }

        res = Math.min(res, i + 1);

        return res;

    }

    public static void main(String[] args) {
        new Solution3().findLengthOfShortestSubarray(new int[] {11,26,3,14,24,6,10,16,32,9,36,24,27,17,31,32,35,36,11,22,30});
    }

}
