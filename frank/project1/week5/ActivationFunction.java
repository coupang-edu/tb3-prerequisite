public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if(Double.isNaN(x)) return Double.NaN;
        double result = 0.0;
        if(x < 0.0) result = 0.0;
        else if(x == 0.0) result = 0.5;
        else if(x > 0.0) result = 1.0;
        return result;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if(Double.isNaN(x)) return Double.NaN;
        return 1.0/(1.0+Math.exp((-1.0)*x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if(Double.isNaN(x)) return Double.NaN;
        return (Math.exp(x) - Math.exp(-x))/(Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if(Double.isNaN(x)) return Double.NaN;
        return x / (1+Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if(Double.isNaN(x)) return Double.NaN;
        double result = 0.0;
        if(x <= -2.0) result = -1;
        else if(x > -2 && x < 0) result = x + (Math.pow(x, 2) / 4.0);
        else if(x >=0 && x < 2) result =  x - (Math.pow(x, 2) / 4.0);
        else if(x>=2) result = 1;
        
        return result;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside("+x+") = "+ heaviside(x));
        System.out.println("sigmoid("+x+") = "+ sigmoid(x));
        System.out.println("tanh("+x+") = "+ tanh(x));
        System.out.println("softsign("+x+") = "+ softsign(x));
        System.out.println("sqnl("+x+") = "+ sqnl(x));
        
        
    }
}
