package com.zouxxxyy;

/**
 * @author zxy
 */
public class Test {

    public static void main(String[] args) {

        int[] arr1 = new int[] {1, 2, 3 ,4, 5 ,6, 7, 8};

        int l = 0, r = arr1.length;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr1[mid] == 4) {
                System.out.println(mid);
                break;
            } else if (arr1[mid] < 4) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }


    }

}
