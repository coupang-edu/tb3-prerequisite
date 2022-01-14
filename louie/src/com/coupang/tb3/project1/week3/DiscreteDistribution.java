package com.coupang.tb3.project1.week3;

public class DiscreteDistribution {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int len = args.length - 1;
        int[] arr = new int[len + 1];
        arr[0] = 0;
        for (int i = 1; i <= len; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(args[i]);
        }

        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * arr[len]);
            for (int j = 1; j <= len; j++) {
                if (r >= arr[j - 1] && r < arr[j]) {
                    System.out.printf("%d ", j );
                    break;
                }
            }
        }
    }
}
