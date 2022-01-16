package com.coupang.tb3.project1.week3;

public class DiscreteDistribution {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length];
        int[] s = new int[args.length];
        for (int i = 1; i < args.length; i++) {
            a[i] = Integer.parseInt(args[i]);
            s[i] = s[i - 1] + a[i];
        }

        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * s[s.length - 1]);
            for (int j = 1; j < s.length; j++) {
                if (r < s[j]) {
                    System.out.print(j + " ");
                    break;
                }
            }
        }
    }
}
