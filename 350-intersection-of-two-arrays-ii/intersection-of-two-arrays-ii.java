class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    for (int num : nums1) {
        list1.add(num);
    }
    for (int num : nums2) {
        list2.add(num);
    }

    for (int num : list1) {
        if (list2.contains(num)) {
            result.add(num);
            list2.remove((Integer) num);
        }
    }

    int[] resultArray = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
        resultArray[i] = result.get(i);
    }
    return resultArray;
    }
}