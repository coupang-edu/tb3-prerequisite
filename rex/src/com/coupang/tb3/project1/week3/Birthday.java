package com.coupang.tb3.project1.week3;

public class Birthday {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] table = new int[n + 2];

        for (int i = 0; i < trials; i++) {
            boolean[] entered = new boolean[n];
            for (int j = 1; j <= n + 1; j++) {
                int r = (int) (Math.random() * n);
                if (entered[r]) {
                    table[j]++;
                    break;
                } else {
                    entered[r] = true;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n + 1; i++) {
            sum += table[i];
            double fraction = (double) sum / trials;
            System.out.println(i + "\t" + table[i] + "\t" + fraction);

            if (fraction >= 0.5) {
                break;
            }
        }
    }
}
