class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int sumOfSet = 0;
        int sumOfArray = 0;

        for (int i : nums) {
            sumOfArray += i;
            if (!s.contains(i)) {
                s.add(i);
                sumOfSet += i;
            }
        }

        return 2 * sumOfSet - sumOfArray;
    }
}