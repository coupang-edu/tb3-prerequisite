package com.coupang.tb3.project1.week4;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.util.Arrays;

public class Checkerboard {

    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        int n = parsed[0];
        draw(n);
    }

    private static void draw(int n) {
        StdDraw.setScale(0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                setColor(i, j);
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }

        StdDraw.show();
    }

    private static void setColor(int i, int j) {
        boolean isBlue = (i % 2 == 0) ^ (j % 2 == 1);
        if (isBlue) {
            StdDraw.setPenColor(Color.BLUE);
        } else {
            StdDraw.setPenColor(Color.LIGHT_GRAY);
        }
    }
}
