package com.coupang.tb3.project1.week1;

import java.util.Arrays;

public class GreatCircle {

    public static final double R = 6371.0;

    public static void main(String[] args) {
        Double[] radians = Arrays.stream(args)
          .map(Double::parseDouble)
          .map(Math::toRadians)
          .toArray(Double[]::new);
        double x1 = radians[0];
        double y1 = radians[1];
        double x2 = radians[2];
        double y2 = radians[3];
        System.out.println(getDistance(x1, y1, x2, y2) + " kilometers");
    }

    private static double getDistance(double x1, double y1, double x2, double y2) {
        return 2 * R * Math.asin(Math.sqrt(Math.pow(Math.sin((x2 - x1) / 2), 2)
          + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2 - y1) / 2), 2)));
    }
}
