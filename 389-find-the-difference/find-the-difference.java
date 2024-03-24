class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26]; // Assuming lowercase English letters only
        // Count the frequency of characters in string s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        // Subtract the frequency of characters in string t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        // Find the character with non-zero frequency
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return (char) ('a' + i);
            }
        }
        // Return '\0' or throw an exception if no character is added
        return '\0';
    }
}
