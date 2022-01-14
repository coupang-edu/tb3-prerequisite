package project1.week1;

public class GreatCircle {
    public static void main(String[] args) { 
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        double dis_x = Math.toRadians(x2 - x1);
        double dis_y = Math.toRadians(y2 - y1);
        double rad_x1 = Math.toRadians(x1);
        double rad_x2 = Math.toRadians(x2);
        double a = Math.pow(Math.sin(dis_x / 2), 2) + Math.pow(Math.sin(dis_y / 2), 2) * Math.cos(rad_x1) * Math.cos(rad_x2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        System.out.println((rad * c) + " kilometers");
    }
    
}
