package com.coupang.tb3.project1.week5;

import edu.princeton.cs.introcs.StdAudio;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class AudioCollage {

    public static final String BEATBOX = "beatbox.wav";
    public static final String BUZZER = "buzzer.wav";
    public static final String CHIMES = "chimes.wav";
    public static final String COW = "cow.wav";
    public static final String DIALUP = "dialup.wav";

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        return Arrays.stream(a)
          .map(d -> d * alpha)
          .toArray();
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        List<Double> list = Arrays.stream(a)
          .boxed()
          .collect(Collectors.toList());
        Collections.reverse(list);
        return list.stream().mapToDouble(Double::doubleValue).toArray();
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        return DoubleStream.concat(Arrays.stream(a.clone()), Arrays.stream(b.clone())).toArray();
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int max = Math.max(aLength, bLength);
        double[] result = new double[max];
        for(int i = 0; i < max; i++) {
            if (i < aLength) {
                result[i] += a[i];
            }
            if (i < bLength) {
                result[i] += b[i];
            }
        }

        return result;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int aLength = a.length;
        int changedLength = (int)(aLength * alpha);
        double[] result = new double[changedLength];
        for (int i = 0; i < changedLength; i++) {
            double indexDouble = i / alpha;
            int indexInt = (int) indexDouble;
            double nextRatio = indexDouble - indexInt;
            double prevRatio = 1 - nextRatio;
            double prevSample = indexInt < aLength ? a[indexInt] : a[aLength - 1];
            double nextSample = indexInt + 1 < aLength ? a[indexInt + 1] : a[aLength - 1];
            result[i] = prevSample * prevRatio + nextSample * nextRatio;
        }
        return result;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        AudioCollage audioCollage = new AudioCollage();
        ClassLoader classLoader = audioCollage.getClass().getClassLoader();
        double[] beatbox = StdAudio.read(classLoader.getResource(BEATBOX).toString());
        double[] buzzer = StdAudio.read(classLoader.getResource(BUZZER).toString());
        double[] chimes = StdAudio.read(classLoader.getResource(CHIMES).toString());
        double[] cow = StdAudio.read(classLoader.getResource(COW).toString());
        double[] dialup = StdAudio.read(classLoader.getResource(DIALUP).toString());

        double[] mySound = amplify(merge(merge(merge(
          changeSpeed(beatbox, 2.3),
          amplify(changeSpeed(buzzer, 0.5), 0.05)),
          mix(chimes, dialup)),
          reverse(cow)),
          0.3);

        StdAudio.play(mySound);
    }

}
