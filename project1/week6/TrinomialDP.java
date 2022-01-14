package project1.week6;

public class TrinomialDP {

    public static long trinomial(int n, int k) {
        if (k < -n || k > n)
            return 0;
        if(n==0 && k==0)
            return 1;
    
        long[][] t = new long[n+2][n+2];
        t[0][0] = 1;
        for (int _n = 0; _n <= n+1; _n++) {
            for (int _k = 0; _k < _n; _k++) {
                t[_n][_k] = (_k == 0) ? t[_n-1][_k] + 2*t[_n-1][_k+1] : t[_n-1][_k-1] + t[_n-1][_k] + t[_n-1][_k+1];
            }
        }
        
        if (k < 0) return t[n+1][-k];
        else return t[n+1][k];
    }
    public static void main(String[] args) {
            int n = Integer.parseInt(args[0]);
            int k = Integer.parseInt(args[1]);
            System.out.println(trinomial(n, k));
    }
}
