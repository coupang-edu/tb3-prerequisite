package com.coupang.tb3.project1.week2;

public class RandomWalkers {
    private static double RandomWalker(int distance) {
        int x = 0;
        int y = 0;
        int step = 0;

        while(true) {
            if (Math.abs(x) + Math.abs(y) == distance) {
                return step;
            }

            int direction = (int) (Math.random() * 4);
            if (direction == 0) {
                x++;
            } else if (direction == 1) {
                x--;
            } else if (direction == 2) {
                y++;
            } else if (direction == 3) {
                y--;
            }
            step++;
        }
    }
    public static void main(String[] args) {
        int distance = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double average = 0;
        for (int i = 0; i < trials; i++) {
            average += RandomWalker(distance);
        }

        average = average / trials;
        System.out.println("average number of steps = " + average);

    }
}
