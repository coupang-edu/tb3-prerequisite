public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        System.out.println(a > 0 && b > 0 && c > 0
                && ((c > a && c > b && (a * a == c * c - b * b))
                || (b > a && b > c && (a * a == b * b - c * c))
                || (a > b && a > c && (b * b == a * a - c * c))));
    }
}
