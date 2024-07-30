class Solution {
    public int minimumDeletions(String s) {
        int ans = 0;
        int count = 0;
        for (char x : s.toCharArray()) {
            if (x == 'b') {
                count += 1;
            } else if (count > 0) {
                ans += 1;
                count -= 1;
            }
        }
        return ans;
    }
}