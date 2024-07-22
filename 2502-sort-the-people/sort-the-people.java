class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        List<String> result = new ArrayList<>();
        for (String name : map.values()) {
            result.add(name);
        }

        return result.toArray(new String[0]);
    }
}