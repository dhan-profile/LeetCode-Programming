class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (n1, n2) -> {
            if (!m.get(n1).equals(m.get(n2))) return m.get(n1) - m.get(n2);
            else return n2 - n1;
        });

        for (int  i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}