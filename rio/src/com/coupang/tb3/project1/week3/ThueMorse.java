package com.coupang.tb3.project1.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThueMorse {

    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        int n = parsed[0];
        printThueMorse(makeThueMorse(n));
    }

    private static int[] makeThueMorse(int n) {
        int[] thueMorse = new int[n];
        for(int i = 1; i <= n; i *= 2) {
            for (int j = i; j < i * 2 && j < n; j++) {
                thueMorse[j] = thueMorse[j-i] ^ 1;
            }
        }
        return thueMorse;
    }

    private static void printThueMorse(int[] thueMorse) {
        int n = thueMorse.length;
        List<String> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            list.clear();
            for (int j = 0; j < n; j++) {
                if (thueMorse[i] == thueMorse[j]) {
                    list.add("+");
                } else {
                    list.add("-");
                }
            }
            System.out.println(String.join("  ", list));
        }
    }

}
