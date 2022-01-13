package project1.week4;

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] freq = new int[m+1];
        int cnt = 0;

        while (!StdIn.isEmpty()) {
                int value = StdIn.readInt();
                freq[value]++;
                cnt++;
        }

        double h = 0;
        for (int i = 1; i < m+1; i++) {
            double pi = ((double) freq[i]) / cnt;
            double log_pi = Math.log(pi) / Math.log(2);
            h += pi * log_pi;
        }

        System.out.println(-h);
    }   
}
