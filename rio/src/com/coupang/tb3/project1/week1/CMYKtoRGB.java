package com.coupang.tb3.project1.week1;

import java.util.Arrays;
import java.util.function.DoubleFunction;

public class CMYKtoRGB {

    public static void main(String[] args) {
        Double[] doubles = Arrays.stream(args)
          .map(Double::parseDouble)
          .toArray(Double[]::new);
        CMYK cmyk = new CMYK(doubles[0], doubles[1], doubles[2], doubles[3]);
        System.out.println(cmyk.toRGB());
    }

    static class CMYK {
        private double c, m, y, k;

        public CMYK(Double c, double m, double y, double k) {
            this.c = c;
            this.m = m;
            this.y = y;
            this.k = k;
        }

        public RGB toRGB() {
            double w = 1 - k;
            double r = 255 * w * (1 - c);
            double g = 255 * w * (1 - m);
            double b = 255 * w * (1 - y);
            return new RGB((int)r, (int)g, (int)b);
        }
    }

    static class RGB {
        private int r, g, b;

        public RGB(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        @Override
        public String toString() {
            return "red   = " + r
              + "\ngreen = " + g
              + "\nblue  = " + b;
        }
    }
}
