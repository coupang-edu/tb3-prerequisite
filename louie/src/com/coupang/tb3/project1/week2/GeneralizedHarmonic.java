package com.coupang.tb3.project1.week2;

public class GeneralizedHarmonic {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);

        double result = 0.0;
        for (int i = 1 ; i <= n ; i++) {
            double denominator = Math.pow(i, r);
            result += 1.0 / denominator;
        }

        System.out.println(result);
    }
}
