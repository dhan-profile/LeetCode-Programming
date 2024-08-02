// class Solution {
//     public int minSwaps(int[] nums) {
//         int n=nums.length;
//         int min=Integer.MAX_VALUE;
//         int one=0;
//         for(int j:nums){
//             if(j==1)one++;
//         }
//         int cnt=0;
//         for (int i = 0; i < one; ++i) {
//             cnt += nums[i];
//         }
//         min = cnt;
        
        
//         for (int i=one; i < n + one; ++i) {
//             cnt += nums[i % n] - nums[(i - one + n) % n];
//             min = Math.max(min, cnt);
//         }
//         return one-min;
//     }
// }

class Solution {
    public int minSwaps(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            k+=nums[i];
        }
        int sum=0; int min=nums.length;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            if(j>=k){sum-=nums[j-k];}
            if(j>=k-1)min=Math.min(min,k-sum);
        }
        for(int i=0;i<=k-2;i++){
            //length-k,...,length-1
            //length-k+1 - 0; length-k+2 - 1; length-k+3 - 2;
            sum=sum+nums[i]-nums[nums.length-k+i];
            min=Math.min(min,k-sum);
        }
        return min;
    }
}