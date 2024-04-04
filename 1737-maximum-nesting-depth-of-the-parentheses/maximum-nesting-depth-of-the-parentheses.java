public class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "(1+(2*3)+((8)/4))+1";
        String s2 = "(1)+((2))+(((3)))";
        System.out.println(solution.maxDepth(s1)); // Output: 3
        System.out.println(solution.maxDepth(s2)); // Output: 3
    }
}
