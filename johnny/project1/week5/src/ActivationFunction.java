public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        return Double.isNaN(x) ? Double.NaN : x < 0.0 ? 0.0 : x == 0 ? 0.5 : 1.0;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        return 1 / (1 + Math.pow(Math.E, -x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (x == Double.POSITIVE_INFINITY || x == Double.MAX_VALUE) {
            return 1.0;
        }
        if (x == Double.NEGATIVE_INFINITY || x == -Double.MAX_VALUE) {
            return -1.0;
        }
        return (Math.pow(Math.E, x) - Math.pow(Math.E, -x)) / (Math.pow(Math.E, x) + Math.pow(Math.E, -x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        if (x == Double.NEGATIVE_INFINITY) {
            return -1.0;
        }
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        return x <= -2 ? -1 :
                x < 0 ? x + x * x / 4 :
                        x < 2 ? x - x * x / 4 : 1;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("tanh(" + x + ") = " + tanh(x));
        System.out.println("softsign(" + x + ") = " + softsign(x));
        System.out.println("sqnl(" + x + ") = " + sqnl(x));
    }
}

