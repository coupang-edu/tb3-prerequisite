public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int steps = 0;
        int distance = 0;
        int i = 0;
        int j = 0;
        System.out.println("("+i+", "+j+")");
        while (distance != r) {
            double dir = Math.random();
            if (dir >= 0 && dir <0.25) i++;
            else if (dir >= 0.25 && dir < 0.5) i--;
            else if (dir >= 0.5 && dir < 0.75) j++;
            else if (dir >=0.75) j--;
            
            System.out.println("("+i+", "+j+")");
            steps ++;
            distance = Math.abs(i) + Math.abs(j);
        }
        System.out.println("steps = "+steps);
    }
}
