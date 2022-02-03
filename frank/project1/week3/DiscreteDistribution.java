public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int length = args.length - 1;
        int[] a = new int[length+1];
        int[] s = new int[length+1];
        for(int i=1; i<=length ; i++) {
            a[i] = Integer.parseInt(args[i]);
            s[i] = s[i-1] + a[i];
            //System.out.println(a[i] +"/"+s[i]);
        }
        
        for(int i=0 ; i<m ;i++) {
            int r = (int)(Math.random()*(s[length] - 1));
            for (int j=1 ; j<=length ; j++) {
                if(s[j-1] <= r && r < s[j]) {
                    System.out.print(j+" ");
                    break;
                }
            }
        }
    }
}
