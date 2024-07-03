class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;
        Arrays.sort(nums);

        // Evaluate the minimum difference possible with at most 3 moves
        int minDiff = Math.min(
            Math.min(nums[n - 1] - nums[3], nums[n - 2] - nums[2]),
            Math.min(nums[n - 3] - nums[1], nums[n - 4] - nums[0])
        );

        return minDiff;
    }
}