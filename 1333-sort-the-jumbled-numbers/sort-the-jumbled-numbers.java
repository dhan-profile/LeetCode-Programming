// import java.util.*;

// class Solution {
//     private int toNum(int n, int[] mapping) {
//         if (n == 0) return 0;
//         return (mapping[n % 10] + toNum(n / 10, mapping) * 10);
//     }

//     public int[] sortJumbled(int[] mapping, int[] nums) {
//         int n = nums.length;
//         List<int[]> a = new ArrayList<>();
        
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == 0) {
//                 a.add(new int[]{mapping[nums[i]], i});
//             } else {
//                 a.add(new int[]{toNum(nums[i], mapping), i});
//             }
//         }
        
//         Collections.sort(a, (x, y) -> x[0] - y[0]);
        
//         int[] ans = new int[n];
//         for (int i = 0; i < n; i++) {
//             ans[i] = nums[a.get(i)[1]];
//         }
        
//         return ans;
//     }
// }

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        // Step 1: Transform each number in nums to its mapped value
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            if (nums[i] == 0) {
                arr[i][1] = mapping[0];
            } else {
                int mappedValue = 0;
                int placeValue = 1;
                for (int j = nums[i]; j > 0; j /= 10) {
                    mappedValue += (mapping[j % 10] * placeValue);
                    placeValue *= 10;
                }
                arr[i][1] = mappedValue;
            }
        }

        // Step 2: Sort the array based on mapped values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 3: Reconstruct the sorted array of original numbers
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i][0];
        }

        return nums;
    }
}