package com.coupang.tb3.project1.week5;

public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (x < 0) return 0;
        else if (x == 0) return 0.5;
        else return 1;

    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        return 1.0 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (x <= -2) {
            return -1;
        }else if (x > -2 && x < 0) {
            return (x + x * x / 4.0);
        } else if (x >= 0 && x < 2) {
            return (x - x * x / 4.0);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);

        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("sigmoid(" + x + ") = "+ sigmoid(x));
        System.out.println("tanh(" + x + ") = "+ tanh(x));
        System.out.println("softsign(" + x + ") = "+ softsign(x));
        System.out.println("sqnl(" + x + ") = "+ sqnl(x));
    }

}
