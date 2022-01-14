public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x < 0) return 0;
        if (x == 0) return 0.5;
        return 1;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        return 1 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (Math.exp(-x) == 0) return 1.0;
        if (Math.exp(x) == 0) return -1.0;
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x == Double.POSITIVE_INFINITY) return 1.0;
        if (x == Double.NEGATIVE_INFINITY) return -1.0;
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x <= -2) return -1;
        if (x < 0) return x + Math.pow(x, 2) / 4;
        if (x < 2) return x - Math.pow(x, 2) / 4;
        return 1;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double input = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + input + ") = " + heaviside(input));
        System.out.println("  sigmoid(" + input + ") = " + sigmoid(input));
        System.out.println("     tanh(" + input + ") = " + tanh(input));
        System.out.println(" softsign(" + input + ") = " + softsign(input));
        System.out.println("     sqnl(" + input + ") = " + sqnl(input));
    }
}

