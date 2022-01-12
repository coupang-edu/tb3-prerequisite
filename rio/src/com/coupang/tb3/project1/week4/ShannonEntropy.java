package com.coupang.tb3.project1.week4;

import edu.princeton.cs.introcs.StdIn;
import java.util.Arrays;

public class ShannonEntropy {

    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        int m = parsed[0];
        int[] count = new int[m];
        for(;!StdIn.isEmpty();) {
            int value = StdIn.readInt();
            count[value-1]++;
        }

        System.out.println(String.format("%.4f", getShannonEntropy(count)));
    }

    private static double getShannonEntropy(int[] count) {
        int m = count.length;
        int total = Arrays.stream(count).sum();
        double[] portion = new double[m];
        double[] terms = new double[m];
        for (int i = 0; i < count.length; i++) {
            portion[i] = (double)count[i] / total;
            if (portion[i] != 0) {
                terms[i] = portion[i] * Math.log(portion[i]) / Math.log(2);
            }
        }
        return -Arrays.stream(terms).sum();
    }
}
