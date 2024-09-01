class Solution {
public int[][] construct2DArray(int[] original, int m, int n) {
    
    // It is possible if and only if m * n == original.length
    if(m*n!=original.length)  return new int[][]{};

    int[][] res = new int[m][n];
    
    for(int i=0;i<original.length;i++)
        res[i/n][i%n]=original[i];
    
    return res;
}
}