public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double avgSteps = 0;

        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;
            while (Math.abs(x) + Math.abs(y) != r) {
                double rand = Math.random();
                if (rand < 0.25) {
                    x = x + 1;
                } else if (rand < 0.5) {
                    y = y + 1;
                } else if (rand < 0.75) {
                    x = x - 1;
                } else {
                    y = y - 1;
                }
                steps = steps + 1;
            }
            avgSteps = avgSteps + steps;
        }

        System.out.println("average number of steps = " + (avgSteps / trials));
    }
}
