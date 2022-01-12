package com.coupang.tb3.project1.week5;

import java.util.Arrays;

public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) {
            return 0;
        }
        for (;b != 0;) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int gcd = gcd(a, b);
        if (gcd == 0) return 0;
        return a * b / gcd;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int count = 0;
        for (int i = 1; i < n ; i++) {
            if (areRelativelyPrime(n, i)) {
                count++;
            }
        }
        return count;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        int a = parsed[0];
        int b = parsed[1];

        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }
}
