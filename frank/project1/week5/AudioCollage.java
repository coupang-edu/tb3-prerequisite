
public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        int length = a.length;
        double[] result = new double[length];
        for(int i=0 ; i<length ;i++)
            result[i] = a[i] * alpha;
        return result;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        int length = a.length;
        double[] result = new double[length];
        int index = 0;
        for(int i=length-1 ; i>=0 ; i--)
            result[index++] = a[i];
        return result;
        
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] result = new double[a.length+b.length];
        int index = 0;
        for(int i=0;i<a.length;i++)
            result[index++] = a[i];
        for(int i=0;i<b.length;i++)
            result[index++] = b[i];
        return result;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int max = Math.max(a.length, b.length);
        double[] result = new double[max];
        if(a.length == b.length) {
            for(int i=0; i<max ; i++) 
                result[i] = a[i] + b[i];
        }
        else if(max == a.length) {
            for(int i= 0;i<max;i++) {
                if(i >= b.length) result[i] = a[i];
                else result[i] = a[i]+b[i];
            }
        }
        else if(max == b.length) {
            for(int i= 0;i<max;i++) {
                if(i >= a.length) result[i] = b[i];
                else result[i] = a[i]+b[i];
            }   
        }
        return result;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int length = (int)(a.length/alpha);
        double[] result = new double[length];
        for(int i=0 ; i<length ; i++) 
            result[i] = a[(int)(i*alpha)];
        return result;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        
        StdAudio.play(amplify(beatbox,2));
        StdAudio.play(reverse(buzzer));
        StdAudio.play(merge(chimes,cow));
        StdAudio.play(mix(chimes,cow));
        StdAudio.play(changeSpeed(dialup,0.5));
    }
}
