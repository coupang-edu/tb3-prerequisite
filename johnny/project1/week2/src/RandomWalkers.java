public class RandomWalkers {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int sum = 0;
        for (int t = 0; t < trials; t++) {
            int i = 0;
            int j = 0;

            int steps = 0;
            while (Math.abs(i) + Math.abs(j) < r) {
                int random = (int) (Math.random() * 100);

                if (random < 25) {
                    i++;
                } else if (random < 50) {
                    i--;
                } else if (random < 75) {
                    j++;
                } else {
                    j--;
                }
                steps++;
            }
            sum += steps;
        }
        System.out.println("average number of steps = " + (sum / (double) trials));
    }
}
