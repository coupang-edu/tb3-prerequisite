package com.coupang.tb3.project1.week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class Birthday {

    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        int n = parsed[0];
        int trial = parsed[1];

        Map<Integer, Integer> result = simulation(n, trial);
        printSummarizedResult(result, trial);
    }

    private static Map<Integer, Integer> simulation(int n, int trial) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < trial; i++) {
            int time = simulation(n);
            //if (time == 1) System.out.println("time=" + time);
            result.put(time, Optional.ofNullable(result.get(time)).orElse(0) + 1);
        }
        return result;
    }

    private static int simulation(int n) {
        Set<Integer> hash = new HashSet<>();
        Random random = new Random();
        for (int i = 1;; i++) {
            int randomNumber = random.nextInt(n);
            if (hash.contains(randomNumber)) {
                return i;
            }
            hash.add(randomNumber);
        }
    }

    private static void printSummarizedResult(Map<Integer, Integer> result, int trial) {
        int accumulate = 0;
        for (int i = 1; accumulate < trial / 2; i++) {
            int count = Optional.ofNullable(result.get(i)).orElse(0);
            accumulate += count;
            System.out.println(i + "\t" + count + "\t" + (double)accumulate / trial);
        }
    }
}
