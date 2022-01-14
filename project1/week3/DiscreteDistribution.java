package project1.week3;

public class DiscreteDistribution {
    public static void main(String[] args) { 
        Integer m = Integer.parseInt(args[0]);
        int n = args.length;
        int[] sum = new int[n];
        for(int i=1; i<n; i++) {  // [0] : 0, [1] : 1, [2]:1+2, ... , [n-1]:1+2+...+(n-1)
            sum[i] = sum[i-1] + Integer.parseInt(args[i]);
        }

        for(int i=0; i<m; i++) {
            int upperBound = n;
            int lowerBound = 0;
            int idx = upperBound / 2;
            int rand_num = (int) (Math.random() * sum[n-1]);

            while (idx > 0 && idx < n) {
                if(sum[idx-1] < rand_num && sum[idx] >= rand_num)
                    break;

                if(sum[idx-1] >= rand_num) {
                    upperBound = idx;
                    idx = (lowerBound + upperBound) / 2;
                } else {
                    lowerBound = idx + 1;
                    idx = (lowerBound + upperBound) / 2;
                }
            }
            System.out.print(idx+1 + " ");
        }
    }
}
