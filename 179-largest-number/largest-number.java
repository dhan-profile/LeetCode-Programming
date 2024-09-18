// class Solution {
//     public String largestNumber(int[] nums) {
//         String s = "";
//         StringBuilder sb = new StringBuilder();
//         for (int n : nums) {
//             // s += n;
//             sb.append(n);
//         }
//         System.out.println(sb);

//         ArrayList<Integer> arr = new ArrayList<>();
//         for (int i = 0; i < sb.length(); i++) {
//             arr.add(sb.charAt(i) - '0');
//         }
//         Collections.sort(arr, Collections.reverseOrder());
//         for (Integer integer : arr) {
//             s += integer;
//         }
//         return s;
//     }
// }

class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];         
        for(int i=0; i<nums.length; i++)  s[i] = String.valueOf(nums[i]);
        Arrays.sort(s, (a,b) -> (b + a).compareTo(a + b));
        return s[0].equals("0") ? "0" : String.join("",s);
    }
}