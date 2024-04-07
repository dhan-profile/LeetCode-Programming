class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        long result = Math.abs(k - nums[nums.length / 2]);
        for (int i = 0; i < nums.length / 2; i++) {
            result += Math.max(0, nums[i] - k);
        }
        for (int i = nums.length / 2 + 1; i < nums.length; i++) {
            result += Math.max(0, k - nums[i]);
}
        return result;
    }
}