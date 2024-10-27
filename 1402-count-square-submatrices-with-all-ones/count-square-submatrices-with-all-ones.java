class Solution {
public int countSquares(int[][] matrix) {
    /*
      Time Complexity: O(MN)
      Space Complexity: O(1) input array is modified
    */

    int result = 0;

    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {

        // for top most row(i == 0) and left most column j == 0, directly
        // value in the matrix will be added as result.
        if(matrix[i][j] > 0 && i > 0 && j > 0) {
          int min = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
          matrix[i][j] = min + 1;
        }

        result += matrix[i][j];
      }
    }

    return result;
  }
}