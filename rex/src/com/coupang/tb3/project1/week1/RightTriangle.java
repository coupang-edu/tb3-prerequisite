package com.coupang.tb3.project1.week1;

public class RightTriangle {

    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        boolean result = (num1 > 0 && num2 > 0 && num3 > 0) && (
          (Math.pow(num1, 2) == Math.pow(num2, 2) + Math.pow(num3, 2))
            || (Math.pow(num2, 2) == Math.pow(num1, 2) + Math.pow(num3, 2))
            || (Math.pow(num3, 2) == Math.pow(num1, 2) + Math.pow(num2, 2))
          );

        System.out.println(result);
    }

}
