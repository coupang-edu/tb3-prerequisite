package com.coupang.tb3.project1.week4;

import com.coupang.tb3.project1.StdLibrary.StdDraw;
import java.awt.Color;

public class Checkerboard {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double xPos = 0.5;
        double yPos = 0.5;
        double halfLength = 0.5;
        boolean isBlue = true;

        StdDraw.setScale(0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StdDraw.setPenColor(isBlue ? Color.blue : Color.lightGray);
                StdDraw.filledSquare(xPos, yPos, halfLength);

                xPos += 1.0;
                isBlue = !isBlue;
            }
            yPos += 1.0;
            xPos = 0.5;
            if (n % 2 == 0) {
                isBlue = !isBlue;
            }
        }
    }
}
