package com.bandaru.sm.miscellaneous;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{4, 6, 2, 3, 0, 7, -9, 5})));
    }

    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] tmp1 = new int[n];
        int[] tmp2 = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                tmp1[i] = 1;
            else
                tmp1[i] = arr[i - 1] * tmp1[i - 1];

        }
        for (int j = n - 1; j >= 0; j--) {
            if (j == n - 1)
                tmp2[j] = 1;
            else
                tmp2[j] = arr[j + 1] * tmp2[j + 1];
        }

        for (int k = 0; k < n; k++) {
            res[k] = tmp1[k] * tmp2[k];
        }
        return res;
    }
}
