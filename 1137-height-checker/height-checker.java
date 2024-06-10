class Solution {
    public int heightChecker(int[] heights) {
        int length = heights.length;
        int[] newHeights = Arrays.copyOf(heights, length);
        
        Arrays.sort(newHeights);

        int difference = 0;
        for (int index = 0; index < length; index++) {
            if (heights[index] != newHeights[index])
                difference++;
        }

        return difference;
    }
}