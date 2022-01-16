package com.coupang.tb3.project1.week3;

public class ThueMorse {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int size = 1;
        while (size < n) {
            size *= 2;
        }

        int[] seq = new int[size];
        seq[0] = 0;
        int stepSize = 1;
        int idx = 1;
        while (idx < size) {
            for (int i = 0; i < stepSize; i++) {
                seq[idx] = seq[idx - stepSize] == 0 ? 1 : 0;
                idx++;
            }
            stepSize *= 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((seq[i] == seq[j] ? "+" : "-") + "  ");
            }
            System.out.println();
        }
    }
}
