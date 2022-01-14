public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] mArr = new int[m];
        double h = 0;
        int count = 0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            mArr[x - 1]++;
            count++;
        }
        for (int i = 0; i < mArr.length; i++) {
            if (mArr[i] != 0) {
                double p = (double) mArr[i] / (double) count;
                h -=  p * (Math.log(p) / Math.log(2));
            }
        }

        System.out.printf("%.4f\n", h);
    }
}
