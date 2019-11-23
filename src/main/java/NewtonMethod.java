public class NewtonMethod {
    private interface Function {
        double eval(double x);
    }

    public double squareRoot(double x) {
        double base = 0.0;
        double initialGuess = 1.0;

        Function f = (double y) -> y*y - x;
        Function fPrime = (double y) -> 2*y;
        return approximate(initialGuess, base, f, fPrime);
    }

    public double approximate(double guess, double prevGuess, Function f, Function fPrime) {
        if (guess == prevGuess) {
            return guess;
        }

        double newGuess = guess - f.eval(guess)/fPrime.eval(guess);
        return approximate(newGuess, guess, f, fPrime);
    }
}
