package com.bandaru.sm.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(find("ABCBDAB", "BDCABA"));
    }

    public static String find(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] arr = new int[n1 + 1][n2 + 1];
        // first row and first columns are already zeros
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    arr[i + 1][j + 1] = arr[i][j] + 1;
                } else {
                    arr[i + 1][j + 1] = Math.max(arr[i + 1][j], arr[i][j + 1]);
                }
            }
        }

        //read substring from the matrix
        StringBuilder sb = new StringBuilder();
        for (int i = n1, j = n2; i > 0 && j > 0; ) {
            if (arr[i][j] == arr[i - 1][j])
                i--;
            else if (arr[i][j] == arr[i][j - 1])
                j--;
            else {
                assert s1.charAt(i) == s2.charAt(j);
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
        }
        return sb.reverse().toString();
    }
}
