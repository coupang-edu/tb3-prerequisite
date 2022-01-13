public class RightTriangle {

    public static void main(String[] args) {
        int arg1 = Integer.parseInt(args[0]);
        int arg2 = Integer.parseInt(args[1]);
        int arg3 = Integer.parseInt(args[2]);

        int a = Math.min(arg1, arg2);
        int bigger = Math.max(arg1, arg2);

        int b = Math.min(bigger, arg3);
        int c = Math.max(bigger, arg3);

        System.out.println((a > 0 && b > 0 && c > 0) && (a * a + b * b == c * c));
    }
}
