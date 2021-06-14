package com.bandaru.sm.dp;

/**
 * Given an array of 'n' numbers, find a contiguous subsequence
 * for which sum of elements is maximum
 */
public class MaximumSumContiguousSubsequence {
    public static void main(String[] args) {
        int[] arr1 = {-2, 11, -4, 13, -5, 2};
        int[] arr2 = {1, -3, 4, -2, -1, 6};
        System.out.println(maxContiguousSum_BF(arr1));
        System.out.println(maxContiguousSum_DP(arr1));

        System.out.println(maxContiguousSum_BF(arr2));
        System.out.println(maxContiguousSum_DP(arr2));
        assert maxContiguousSum_BF(arr1) == maxContiguousSum_DP(arr1);
        assert maxContiguousSum_BF(arr2) == maxContiguousSum_DP(arr2);
    }

    // T = O(n^2)
    public static int maxContiguousSum_BF(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    // T = O(n), S = O(1)
    public static int maxContiguousSum_DP(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
