package com.coupang.tb3.project1.week3;

public class ThueMorse {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] arr = new boolean[100000];
        arr[0] = false;

        int idx = 1;
        for (int i = 1; i < n; i = i * 2) {
            for (int j = 0; j < i; j++) {
                arr[idx++] = !arr[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    System.out.printf("+  ");
                } else {
                    System.out.printf("-  ");
                }
            }
            System.out.printf("\n");
        }


    }
}
