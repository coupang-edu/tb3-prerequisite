package com.coupang.tb3.project1.week1;

public class GreateCircle {

    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        double r = 6371.0;
        double arg1 = Math.pow(Math.sin((x2 - x1) / 2.0), 2.0);
        double arg2 = Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2 - y1) / 2.0), 2.0);

        double arg3 = 2 * r * Math.asin(Math.sqrt(arg1 + arg2));
        System.out.println(arg3 + " kilometers");

    }
}
