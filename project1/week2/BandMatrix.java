package project1.week2;

public class BandMatrix {
    public static void main(String[] args) { 
        Integer n = Integer.parseInt(args[0]);
        Integer width = Integer.parseInt(args[1]);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int dis = Math.abs(i - j);
                if (dis <= width)
                    System.out.print('*');
                else
                    System.out.print('0');
            }
            System.out.print('\n');
        }
    }
}
