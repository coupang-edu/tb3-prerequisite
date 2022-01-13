public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        int N = a.length;
        double[] b = new double[N];
        for (int i = 0; i < N; i++) {
            b[i] = a[i] * alpha;
        }
        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        int N = a.length;
        double[] b = new double[N];
        for (int i = 0; i < N; i++) {
            b[N - i - 1] = a[i];
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        int N = a.length + b.length;
        double[] c = new double[N];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            c[index++] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[index++] = b[i];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] c = new double[Math.max(a.length, b.length)];
        if (a.length < b.length) {
            double[] temp = a;
            a = b;
            b = temp;
        }
        int i = 0;
        for (; i < b.length; i++) {
            c[i] = a[i] + b[i];
        }
        for (i = b.length; i < a.length; i++) {
            c[i] = a[i];
        }
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int N = (int) (a.length / alpha);
        double[] b = new double[N];
        for (int i = 0; i < N && i * alpha < a.length; i++) {
            b[i] = a[(int) (i * alpha)];
        }
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] exposure = StdAudio.read("exposure.wav");

        StdAudio.play(amplify(beatbox, 0.5));

        StdAudio.play(reverse(exposure));

        StdAudio.play(merge(buzzer, chimes));

        StdAudio.play(amplify(mix(harp, piano), 0.5));

        StdAudio.play(changeSpeed(dialup, 3.0));
    }
}
