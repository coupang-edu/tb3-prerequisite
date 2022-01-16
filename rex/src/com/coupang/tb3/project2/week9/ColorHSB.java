package com.coupang.tb3.project2.week9;

import com.coupang.tb3.project1.StdLibrary.StdIn;

public class ColorHSB {

    private static final int MAX_HUE = 360;
    private static final int MAX_SATURATION = 100;
    private static final int MAX_BRIGHTNESS = 100;

    private final int h;
    private final int s;
    private final int b;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h >= MAX_HUE || s < 0 || s > MAX_SATURATION || b < 0 || b > MAX_BRIGHTNESS) {
            throw new IllegalArgumentException();
        }
        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (s == 0 || b == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException();
        }

        int distance = (int) (Math.min(Math.pow(h - that.h, 2), Math.pow(MAX_HUE - Math.abs(h - that.h), 2)) + Math
          .pow(s - that.s, 2) + Math.pow(b - that.b, 2));
        return distance;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB colorHsb = new ColorHSB(h, s, b);

        int minDistance = Integer.MAX_VALUE;
        String colorName = "";
        ColorHSB minColorHsb = new ColorHSB(0, 0, 0);
        while (!StdIn.isEmpty()) {
            String thisName = StdIn.readString();
            int thisH = StdIn.readInt();
            int thisS = StdIn.readInt();
            int thisB = StdIn.readInt();
            ColorHSB thisColor = new ColorHSB(thisH, thisS, thisB);
            int distance = thisColor.distanceSquaredTo(colorHsb);

            if (distance < minDistance) {
                minDistance = distance;
                colorName = thisName;
                minColorHsb = thisColor;
            }
        }

        System.out.println(colorName + " " + minColorHsb);
    }
}
