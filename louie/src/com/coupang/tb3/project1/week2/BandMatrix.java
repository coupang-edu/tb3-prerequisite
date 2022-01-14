package com.coupang.tb3.project1.week2;

public class BandMatrix {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int w = Integer.parseInt(args[1]);

        for (int i = 0; i < n ;i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i - w && j <= i + w) {
                    System.out.printf("* ");
                } else {
                    System.out.printf("0 ");
                }
            }
            System.out.printf("\n");
        }
    }
}
