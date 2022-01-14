package com.coupang.tb3.project1.week1;

public class RightTriangle {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);


        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("false");
            return;
        }
        if (a * a + b * b == c * c) {
            System.out.println("true");
        } else if (b * b + c * c == a * a) {
            System.out.println("true");
        } else if (a * a + c * c == b * b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
