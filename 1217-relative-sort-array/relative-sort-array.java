class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int size = arr1.length;
        int j = 0, k = 0;
        int[] result = new int[size];
        while (j < arr2.length) {
            for (int n : arr1) {
                if (n == arr2[j]) {
                    result[k++] = n;
                }
            }
            j++;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : arr2) {
            set.add(n);
        }
        for (int n : arr1) {
            if (!set.contains(n)) {
                result[k++] = n;
            }
        }
        return result;
    }
}