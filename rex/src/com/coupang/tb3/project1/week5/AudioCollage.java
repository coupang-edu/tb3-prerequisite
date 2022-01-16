package com.coupang.tb3.project1.week5;

import com.coupang.tb3.project1.StdLibrary.StdAudio;

public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] amplifiedA = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            amplifiedA[i] = a[i] * alpha;
        }

        return amplifiedA;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] reversedA = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            reversedA[a.length - i - 1] = a[i];
        }
        return reversedA;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] mergedA = new double[a.length + b.length];
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            mergedA[idx++] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            mergedA[idx++] = b[i];
        }
        return mergedA;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] mixedA = new double[Math.max(a.length, b.length)];
        int idx = 0;
        while (idx < a.length || idx < b.length) {
            mixedA[idx] = (idx < a.length ? a[idx] : 0) + (idx < b.length ? b[idx] : 0);
            idx++;
        }
        return mixedA;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] changedA = new double[(int) (a.length / alpha)];
        for (int i = 0; i < changedA.length; i++) {
            changedA[i] = a[(int) (i * alpha)];
        }
        return changedA;
    }

    private static double[] trimTones(double[] a) {
        double[] trimedA = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            trimedA[i] = a[i] >= 0 ? Math.min(a[i], 1.0) : Math.max(a[i], -1);
        }
        return trimedA;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] singer = StdAudio.read("singer.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");

        double[] amplifiedHarp = amplify(harp, 2);
        double[] pianoAndHarp = merge(piano, harp);
        double[] changedSinger = changeSpeed(singer, 1.5);
        double[] reversedDialup = reverse(dialup);

        StdAudio
          .play(trimTones(mix(mix(mix(amplifiedHarp, pianoAndHarp), mix(changedSinger, reversedDialup)), beatbox)));
    }
}
