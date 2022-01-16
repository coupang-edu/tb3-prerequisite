package com.coupang.tb3.project2.week7;

public class Ramanujan {

    private static final int MAXVAL = 2097151;

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int firstMatch = 0;
        for (int i = 1; i < MAXVAL; i++) {
            long val = (long) i * i * i;
            if (val >= n) {
                break;
            }
            double remain = Math.cbrt(n - val);
            if ((int) remain == remain) {
                firstMatch = i;
                break;
            }
        }

        if (firstMatch > 0) {
            for (int i = firstMatch + 1; i < MAXVAL; i++) {
                long val = (long) i * i * i;
                if (val >= n) {
                    break;
                }
                double remain = Math.cbrt(n - val);
                if ((int) remain == remain && (int) remain != firstMatch) {
                    return true;
                }
            }
        }

        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));

    }
}
