package com.coupang.tb3.project1.week3;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DiscreteDistribution {

    public static final int PAGE_SIZE = 25;

    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        int m = parsed[0];
        int a[] = new int[args.length];
        int s[] = new int[args.length];
        int sum = 0;
        for (int i = 1; i < args.length; i++) {
            sum += parsed[i];
            a[i] = parsed[i];
            s[i] = sum;
        }
        Random random = new Random();
        List<Integer> result = random.ints(m, 0, sum)
          .map(i -> Arrays.binarySearch(s, i))
          .map(i -> i >= 0 ? i : ~i - 1)
          .map(i -> i + 1)
          .boxed()
          .collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
            if (i % PAGE_SIZE == PAGE_SIZE - 1) {
                System.out.println();
            }
        }

    }
}
