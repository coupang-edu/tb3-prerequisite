package com.coupang.tb3.project1.week2;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class RandomWalkers {

    public static void main(String[] args) {
        Integer[] parsed = Arrays.stream(args)
          .map(Integer::new)
          .toArray(Integer[]::new);
        int r = parsed[0];
        int trial = parsed[1];
        double average = IntStream.range(1, trial)
          .parallel()
          .map((i)->RandomWalker.randomWalk(r, false))
          .average().orElse(0);
        System.out.println("average number of steps = " + average);
    }
}
