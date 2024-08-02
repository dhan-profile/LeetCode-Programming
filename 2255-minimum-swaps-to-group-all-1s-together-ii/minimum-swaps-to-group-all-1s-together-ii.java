class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int one=0;
        for(int j:nums){
            if(j==1)one++;
        }
        int cnt=0;
        for (int i = 0; i < one; ++i) {
            cnt += nums[i];
        }
        min = cnt;
        
        
        for (int i=one; i < n + one; ++i) {
            cnt += nums[i % n] - nums[(i - one + n) % n];
            min = Math.max(min, cnt);
        }
        return one-min;
    }
}