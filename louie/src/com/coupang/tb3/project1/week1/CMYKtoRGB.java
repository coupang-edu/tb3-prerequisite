package com.coupang.tb3.project1.week1;

public class CMYKtoRGB {

    public static void main(String[] args) {
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        int white = 1 - (int) black;
        int red = (int) (255 * white * (1.0 - cyan));
        int green = (int) (255 * white * (1.0 - magenta));
        int blue = (int) (255 * white * (1.0 - yellow));

        System.out.println("red = " + red);
        System.out.println("green = " + green);
        System.out.println("blue = " + blue);
    }
}
