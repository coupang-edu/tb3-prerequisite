package com.coupang.tb3.project1.week2;

import java.util.Arrays;
import java.util.Random;

public class RandomWalker {

    public enum Direction {
        UP(0, 1),
        RIGHT(1, 0),
        DOWN(0, -1),
        LEFT(-1, 0);

        private int x;
        private int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        System.out.println(randomWalk(parsed[0], true));
    }

    public static int randomWalk(int r, boolean print) {
        int x = 0, y = 0, count = 0;
        Random random = new Random();
        if (print) {
            System.out.println("(" + x + ", " + y + ")");
        }
        for(;Math.abs(x) + Math.abs(y) < r; count++) {
            Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
            x = x + direction.getX();
            y = y + direction.getY();
            if (print) {
                System.out.println("(" + x + ", " + y + ")");
            }
        }
        return count;
    }
}
