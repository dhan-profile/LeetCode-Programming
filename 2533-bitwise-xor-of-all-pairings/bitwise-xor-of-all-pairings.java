class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0;
        for (int num : nums1) {
            xor1 ^= num;
        }
        
        int xor2 = 0;
        for (int num : nums2) {
            xor2 ^= num;
        }
        
        return (xor1 * (nums2.length % 2 == 1 ? 1 : 0)) ^ (xor2 * (nums1.length % 2 == 1 ? 1 : 0));
    }
}
