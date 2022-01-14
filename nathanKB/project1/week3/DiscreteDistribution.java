public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] s = new int[args.length];
        s[0] = 0;
        for (int i = 1; i < args.length; i++) {
            s[i] = s[i - 1] + Integer.parseInt(args[i]);
        }

        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * s[s.length - 1]);
            for (int j = 1; j < s.length; j++) {
                if (r < s[j]) {
                    System.out.print(j);
                    break;
                }
            }
            if ((i + 1) % 25 == 0) {
                System.out.println();
            } else if (i != m - 1) {
                System.out.print(" ");
            }
        }
    }
}
