package project1.week2;

public class RandomWalker {
    public static void main(String[] args) { 
        Integer r = Integer.parseInt(args[0]);
        int x_pos = 0;
        int y_pos = 0;
        int steps = 0;
        while (true) {
            System.out.println("("+ x_pos + ", " + y_pos + ")");

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

        System.out.println("steps : "+ steps);
    }
}
