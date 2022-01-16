package com.coupang.tb3.project2.week7;

import com.coupang.tb3.project1.StdLibrary.StdIn;

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        if (a.length == 1) {
            return a[0][0];
        }

        int[][] dp = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            dp[0][i] = a[0][i];
            dp[i][0] = a[i][0];
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        int size = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                size = Math.max(size, dp[i][j]);
            }
        }
        return size;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        System.out.println(size(a));

        String example = "abcdabcdeabcd";
        String s = example.substring(1, 4);
        String t = example.substring(5, 8);
        System.out.println(s);
        System.out.println(t);
        System.out.println(s.equals(t));

        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        System.out.println(string1 + string2);
    }
}
