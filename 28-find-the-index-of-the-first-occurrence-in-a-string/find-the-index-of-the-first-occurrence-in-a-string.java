class Solution {
    public int strStr(String haystack, String needle) {
               if (needle.isEmpty()) {
            return 0; // Empty needle matches at the beginning
        }
        
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            int j;
            for (j = 0; j < needleLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // Characters don't match, move to the next index in haystack
                }
            }
            if (j == needleLength) {
                return i; // Found needle at index i in haystack
            }
        }
        
        return -1; // Needle not found in haystack
    }
}