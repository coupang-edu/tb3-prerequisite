package com.coupang.tb3.project1.week5;

public class Divisors {
    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        while(true) {
            if (b == 0) return a;
            int temp = b;
            b = a % b;
            a = temp;
        }
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b){
        int num = gcd(a,b);
        return (Math.abs(a) * Math.abs(b)) / num;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b){
        if (gcd(a,b) == 1) return true;
        else return false;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int count = 0;
        for (int i=1;i<=n;i++) {
            if (areRelativelyPrime(n, i)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
        System.out.println(areRelativelyPrime(a,b));
        System.out.println(totient(a));
        System.out.println(totient(b));

    }
}
