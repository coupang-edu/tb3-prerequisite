package project1.week2;

public class GeneralizedHarmonic {
    public static void main(String[] args) { 
        Integer n = Integer.parseInt(args[0]);
        Integer r = Integer.parseInt(args[1]);
        Double ret = 0.0;
        for(int i=1; i<=n; i++) {
            ret += 1 / (Math.pow(i, r));
        }

        System.out.println(ret);
    }
}
