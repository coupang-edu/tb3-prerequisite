package com.coupang.tb3.project1.week3;

public class Birthday {

    public static void main(String[] args) {
        int day = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int sum = 0;
        int person = 1;
        int[][] birth = new int[trials + 1][day + 1];
        boolean[] skip = new boolean[trials + 1];

        while(true) {
            int count = 0;
            for (int i = 0; i < trials; i++) {
                int d = (int) (Math.random() * day);
                if (skip[i] == true) continue;

                if (birth[i][d] == 1) {
                    count++;
                    skip[i] = true;
                }
                birth[i][d]++;
            }

            sum += count;
            double fraction = (double) sum / trials;
            System.out.println(person + ", " + count + ", " + fraction);
            if (fraction > 0.5) break;
            person++;
        }


    }
}
