package com.coupang.tb3.project2.week6;

public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k < -n || k > n) {
            return 0;
        }
        long[][] dp = new long[n + 1][n + 2];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = dp[i - 1][Math.abs(j - 1)] + dp[i - 1][j] + dp[i - 1][j + 1];
            }
        }

        return dp[n][Math.abs(k)];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
