package com.coupang.tb3.project2.week6;

public class RevesPuzzle {

    private static void hanoi(int n, String from, String to, String via, int offset) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, from, via, to, offset);
        System.out.println("Move disc " + (n + offset) + " from " + from + " to " + to);
        hanoi(n - 1, via, to, from, offset);
    }

    private static void reves(int n, String from, String to, String via, String via2) {
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        if (k == 0) {
            System.out.println("Move disc " + 1 + " from " + from + " to " + to);
            return;
        }

        reves(k, from, via, to, via2);
        hanoi(n - k, from, to, via2, k);
        reves(k, via, to, from, via2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "D", "B", "C");
    }
}
