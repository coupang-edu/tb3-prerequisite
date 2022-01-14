public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * alpha;
        }
        return c;
    }


    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[a.length - i - 1];
        }
        return c;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[a.length + i] = b[i];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        boolean largeA = true;
        double[] c;
        if (a.length < b.length) largeA = false;
        if (largeA) {
            c = new double[a.length];
            for (int i = 0; i < b.length; i++) {
                c[i] = a[i] + b[i];
            }
            for (int i = b.length; i < a.length; i++) {
                c[i] = a[i];
            }
        } else {
            c = new double[b.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] + b[i];
            }
            for (int i = a.length; i < b.length; i++) {
                c[i] = b[i];
            }
        }
        return c;
    }           

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int sampleSize = (int) (a.length / alpha);
        double[] c = new double[sampleSize];
        for (int i = 0; i < sampleSize; i++) {
            c[i] = a[(int) (i * alpha)];
        }
        return c;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] silence = StdAudio.read("silence.wav");
        double[] singer = StdAudio.read("singer.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        singer = amplify(singer, 0.8);
        dialup = amplify(changeSpeed(dialup, 1.5), 0.2);
        piano = amplify(merge(piano, piano), 0.7);
        piano = merge(piano, reverse(piano));
        harp = amplify(harp, 0.7);
        harp = changeSpeed(merge(merge(harp, harp), harp), 0.6);
        chimes = amplify(chimes, 0.5);
        chimes = changeSpeed(merge(chimes, chimes), 0.5);

        double[] ret1 = mix(singer, dialup);
        double[] ret2 = mix(ret1, piano);
        double[] ret3 = mix(ret2, merge(silence, harp));
        double[] ret = amplify(mix(ret3, merge(silence, chimes)), 0.8);
        StdAudio.play(ret);
    }
}

