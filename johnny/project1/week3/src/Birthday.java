public class Birthday {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trial = Integer.parseInt(args[1]);

        double fraction = 0.0;
        for (int person = 1; person <= n + 1; person++) {
            int count = 0;
            for (int t = 1; t <= trial; t++) {
                boolean[] days = new boolean[n];
                for (int i = 0; i < person; i++) {
                    int random = (int) Math.round(Math.random() * (n - 1));
                    if (days[random]) {
                        if (i == person - 1) {
                            count++;
                        }
                        break;
                    }
                    days[random] = true;
                }
            }
            fraction += count / (double) trial;
            fraction = Math.min(fraction, 1.0);
            System.out.println(person + "\t" + count + "\t" + fraction);
            if (fraction >= 0.5) {
                break;
            }
        }
    }
}
