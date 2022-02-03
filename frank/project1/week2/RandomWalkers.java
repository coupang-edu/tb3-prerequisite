public class RandomWalkers {
    
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        
        int totalSteps = 0;
        
        for (int k=0 ; k< trials ; k++) {
            int steps = 0;
            int distance = 0;
            int i = 0;
            int j = 0;
            while (distance != r) {
                double dir = Math.random();
                if (dir >= 0 && dir <0.25) i++;
                else if (dir >= 0.25 && dir < 0.5) i--;
                else if (dir >= 0.5 && dir < 0.75) j++;
                else if (dir >=0.75) j--;
                steps ++;
                distance = Math.abs(i) + Math.abs(j);
            }
            totalSteps += steps;
        }
             
        double average = (double)totalSteps / (double)trials;
        System.out.println("average number of steps = "+average);
    }
        
}
