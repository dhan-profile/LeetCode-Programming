class Solution {
    public String fractionAddition(String expression) {

        expression = expression.replace("-", "+-");
        String[] fractions = expression.split("\\+");
        
        int numerator = 0, denominator = 1;
        
        for (String fraction : fractions) {
            if (!fraction.isEmpty()) {
                String[] parts = fraction.split("/");
                int num = Integer.parseInt(parts[0]);
                int den = Integer.parseInt(parts[1]);
                
                numerator = numerator * den + num * denominator;
                denominator *= den;
                
                int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
                numerator /= gcd;
                denominator /= gcd;
            }
        }
        
        return numerator + "/" + denominator;
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}