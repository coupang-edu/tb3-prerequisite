package com.coupang.tb3.project1.week5;

import java.util.Arrays;

public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (x == Double.NaN) {
            return Double.NaN;
        }
        if (x < 0) {
            return 0;
        } else if(x == 0) {
            return 0.5;
        } else {
            return 1;
        }
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (x == Double.NaN) {
            return Double.NaN;
        }
        return 1 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (x == Double.NaN) {
            return Double.NaN;
        }
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (x == Double.NaN) {
            return Double.NaN;
        }
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (x == Double.NaN) {
            return Double.NaN;
        }
        if (x <= -2) {
            return -1;
        } else if (x < 0) {
            return x + x * x / 4;
        } else if (x < 2) {
            return x - x * x / 4;
        } else {
            return 1;
        }
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        Double[] parsed = Arrays.stream(args)
          .map(Double::new)
          .toArray(Double[]::new);
        double x = parsed[0];
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("  sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("     tanh(" + x + ") = " + tanh(x));
        System.out.println(" softsign(" + x + ") = " + softsign(x));
        System.out.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}
