public class ShannonEntropy {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        int[] integers = new int[m + 1];
        int total = 0;
        while (!StdIn.isEmpty()) {
            integers[StdIn.readInt()]++;
            total++;
        }

        double shannonEntropy = 0;
        for (int i = 1; i <= m; i++) {
            if (integers[i] == 0) {
                continue;
            }
            double p = integers[i] / (double) total;
            shannonEntropy += -p * Math.log(p) / Math.log(2);
        }
        StdOut.printf("%.4f", shannonEntropy);
    }
}
