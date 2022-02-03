public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int number = 0;
        int[] x = new int[m+1];
        
        while(!StdIn.isEmpty()) {
            int index = StdIn.readInt();
            x[index]++;
            number++;
            //StdOut.println(index);
        }
        
        double h = 0.0;
        for(int i=1 ; i<=m ; i++) {
            double p = (double)x[i] / (double)number;
            //StdOut.println("p:"+p);
            if(p != 0)
                h += (-1.0) * p * Math.log(p)/Math.log(2.0);
        }
        StdOut.printf("%.4f\n",h);
    }
}
