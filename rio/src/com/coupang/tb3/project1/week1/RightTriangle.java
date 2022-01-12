package com.coupang.tb3.project1.week1;

import java.util.ArrayList;
import java.util.List;

public class RightTriangle {

    public static void main(String[] args) {
        boolean result = false;
        try {
            if (args.length == 3) {
                List<Integer> list = new ArrayList<>();
                for (String arg : args) {
                    list.add(Integer.parseInt(arg));
                }
                list.sort(Integer::compareTo);
                int a = list.get(0);
                int b = list.get(1);
                int c = list.get(2);
                if (a > 0 && b > 0 && c > 0) {
                    if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                        result = true;
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("please input only integer string");
        }
        System.out.println(result);
    }
}
