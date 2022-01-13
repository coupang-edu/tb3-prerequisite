public class DiscreteDistribution {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int a[] = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            a[i - 1] = Integer.parseInt(args[i]);
        }

        int s[] = new int[a.length];
        s[0] = a[0];
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i - 1] + a[i];
        }

        int max = s[s.length - 1] - 1;
        for (int t = 0; t < m; t++) {
            int random = (int) Math.round(Math.random() * max);
            for (int i = 0; i < s.length; i++) {
                if (random < s[i]) {
                    System.out.print(i + 1 + " ");
                    break;
                }
            }
        }
    }
}

