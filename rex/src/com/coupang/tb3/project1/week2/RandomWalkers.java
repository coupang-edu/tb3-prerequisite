package com.coupang.tb3.project1.week2;

public class RandomWalkers {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int totalSteps = 0;

        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;

            while (Math.abs(x) + Math.abs(y) != r) {
                int dir = (int) (Math.random() * 4);
                if (dir == 0) {
                    x++;
                } else if (dir == 1) {
                    x--;
                } else if (dir == 2) {
                    y++;
                } else {
                    y--;
                }
                steps++;
            }

            totalSteps += steps;
        }

        System.out.println("average number of steps = " + (double) totalSteps / trials);
    }
}
