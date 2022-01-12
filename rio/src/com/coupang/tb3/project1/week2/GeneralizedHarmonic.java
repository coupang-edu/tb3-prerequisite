package com.coupang.tb3.project1.week2;

import java.util.Arrays;

public class GeneralizedHarmonic {

    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        System.out.println(getGeneralizedHarmonic(parsed[0], parsed[1]));
    }

    private static double getGeneralizedHarmonic(int n, int r) {
        double result = 0;
        for (int i = 1; i <= n; i++) {
            result += 1 / Math.pow(i, r);
        }

        return result;
    }
}
