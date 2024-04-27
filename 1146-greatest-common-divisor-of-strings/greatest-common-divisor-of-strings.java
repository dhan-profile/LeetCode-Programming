class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return ""; // If str1 and str2 don't have the same GCD, return empty string
        }

        // Find the length of the GCD string using the GCD of lengths of str1 and str2
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the substring of str1 from index 0 to gcdLength
        return str1.substring(0, gcdLength);
    }

    // Method to compute the greatest common divisor (GCD) of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
