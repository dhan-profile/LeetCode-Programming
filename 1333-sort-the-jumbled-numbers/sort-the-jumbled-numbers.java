import java.util.*;

class Solution {
    private int toNum(int n, int[] mapping) {
        if (n == 0) return 0;
        return (mapping[n % 10] + toNum(n / 10, mapping) * 10);
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<int[]> a = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                a.add(new int[]{mapping[nums[i]], i});
            } else {
                a.add(new int[]{toNum(nums[i], mapping), i});
            }
        }
        
        Collections.sort(a, (x, y) -> x[0] - y[0]);
        
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[a.get(i)[1]];
        }
        
        return ans;
    }
}