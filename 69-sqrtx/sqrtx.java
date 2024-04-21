class Solution {
    public static int mySqrt(int x) {
        int squareRoot = (int) findSquareRoot(x);
        return squareRoot;
    }

    public static double findSquareRoot(double number) {
        double epsilon = 0.00001; // Desired precision
        double guess = number / 2.0; // Initial guess
        double prevGuess;

        do {
            prevGuess = guess;
            guess = (guess + number / guess) / 2.0; // Newton-Raphson formula
        } while (Math.abs(prevGuess - guess) > epsilon);

        return guess;
    }
}
