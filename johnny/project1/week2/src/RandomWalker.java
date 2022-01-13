public class RandomWalker {

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);

        int i = 0;
        int j = 0;

        int steps = 0;
        while (Math.abs(i) + Math.abs(j) < r) {
            System.out.println("(" + i + ", " + j + ")");
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
        System.out.println("(" + i + ", " + j + ")");
        System.out.println("steps = " + steps);
    }
}
