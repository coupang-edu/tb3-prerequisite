package com.coupang.tb3.project1.week1;

public class HelloGoodbye {

    public static void main(String[] args) {
        if (args.length >= 2) {
            System.out.println("Hello " + args[0] +" and " + args[1] + ".\n"
                + "Goodbye " + args[1] + " and " + args[0] + ".");
        }
    }
}
