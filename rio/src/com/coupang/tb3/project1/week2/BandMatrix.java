package com.coupang.tb3.project1.week2;

import java.util.Arrays;

public class BandMatrix {

    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        printBandMatrix(parsed[0], parsed[1]);
    }

    private static void printBandMatrix(int n, int width) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j <= i + width && j >= i - width) {
                    System.out.print("* ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

}
