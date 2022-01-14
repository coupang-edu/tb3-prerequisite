package project1.week2;

public class RandomWalkers {
    
    public static void main(String[] args) { 
            Integer r = Integer.parseInt(args[0]);
            int trials = Integer.parseInt(args[1]);
            int steps_sum = 0;
            for(int cnt=0; cnt<trials; cnt++) {
            int x_pos = 0;
            int y_pos = 0;
            int steps = 0;
            while (true) {
                if (Math.abs(x_pos) + Math.abs(y_pos) == r) {
                    break;
                }

                steps++;
                int direction = (int)(Math.random() * 4);
                switch(direction) {
                    case 0: x_pos++; break;
                    case 1: x_pos--; break;
                    case 2: y_pos++; break;
                    case 3: y_pos--; break;
                }

            }
            steps_sum += steps;
        }

        System.out.println("average number of steps = "+ steps_sum/trials);
    }
}
