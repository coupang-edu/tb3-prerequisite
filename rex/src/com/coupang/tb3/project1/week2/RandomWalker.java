package com.coupang.tb3.project1.week2;

public class RandomWalker {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;

        System.out.println("(" + x + ", " + y + ")");
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
            System.out.println("(" + x + ", " + y + ")");
        }

        System.out.println("steps = " + steps);
    }
}
