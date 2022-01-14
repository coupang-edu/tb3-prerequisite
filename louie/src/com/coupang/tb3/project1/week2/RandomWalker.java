package com.coupang.tb3.project1.week2;

public class RandomWalker {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int distance = Integer.parseInt(args[0]);
        int step = 0;

        while(true) {
            System.out.println("(" + x + "," + y + ")");

            if (Math.abs(x) + Math.abs(y) == distance) {
                System.out.println("step = " + step);
                return;
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
}
