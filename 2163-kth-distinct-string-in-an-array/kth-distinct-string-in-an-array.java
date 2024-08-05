class Solution {
    public String kthDistinct(String[] arr, int k) {
        // Step 1: Count the occurrences of each string
        Map<String, Integer> counts = new HashMap<>();
        for (String s : arr) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }

        // Step 2: Filter out the distinct strings (strings that appear only once)
        Map<String, Integer> distinctStrings = new LinkedHashMap<>();
        for (String s : arr) {
            if (counts.get(s) == 1) {
                distinctStrings.put(s, distinctStrings.size() + 1);
            }
        }

        // Step 3: Find the k-th distinct string
        for (Map.Entry<String, Integer> entry : distinctStrings.entrySet()) {
            if (entry.getValue() == k) {
                return entry.getKey();
            }
        }

        // If there are fewer than k distinct strings, return an empty string
        return "";








        // Map<String, Integer> frequencyMap = new HashMap<>();
        // int distinctCount = 0;

        // for (String str : arr) {
        //     frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        //     if (frequencyMap.get(str) == 1) {
        //         distinctCount++;
        //         if (distinctCount == k) {
        //             return str;
        //         }
        //     }
        // }

        // return "";
        // LinkedHashSet<String> set = new LinkedHashSet<String>();
        // for (String s : arr) {
        // set.add(s);
        // }
        // String[] str = new String[set.size()];
        // str = set.toArray(str);
        // if (k <= str.length) {
        // if (str[k] != "") {
        // return str[k - 1];
        // }
        // }
        // return "";
    }
}