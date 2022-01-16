package com.coupang.tb3.project2.week7;

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long cnt = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        int idx = 0;
        int min = 0;
        int max = n - 1;

        while (k > 0) {
            // n - idx - 1 : 현재 위치에 max값 놨을때 얻을수 있는 inversion count
            if (k >= n - idx - 1) {
                a[idx] = max--;
                k -= (n - idx - 1);
            } else {
                a[idx] = min++;
            }
            idx++;
        }
        for (int i = min; i <= max; i++) {
            a[idx++] = i;
        }
        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] a = generate(n, k);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
//        System.out.println();
//        System.out.println(count(a));
    }
}
