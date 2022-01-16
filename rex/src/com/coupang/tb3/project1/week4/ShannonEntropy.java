package com.coupang.tb3.project1.week4;

import com.coupang.tb3.project1.StdLibrary.StdIn;

public class ShannonEntropy {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] x = new int[m + 1];
        int cnt = 0;

        while (!StdIn.isEmpty()) {
            int item = StdIn.readInt();
            x[item]++;
            cnt++;
        }

        // calc H
        double h = 0.0;
        for (int i = 1; i <= m; i++) {
            if (x[i] > 0) {
                double p = (double) x[i] / cnt;
                h -= p * (Math.log(p) / Math.log(2));
            }
        }

        System.out.printf("%.4f", h);
    }
}
