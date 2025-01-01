public class Solution {
    public int maxScore(String s) {
        int maxScore = 0;
        int zeros = 0;
        int ones = 0;

        // Count the total number of ones in the string
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }

        // Iterate through the string and calculate the score for each split
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }
            maxScore = Math.max(maxScore, zeros + ones);
        }

        return maxScore;
    }
}
