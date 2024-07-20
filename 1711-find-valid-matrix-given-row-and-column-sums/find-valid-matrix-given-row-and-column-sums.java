class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int r=rowSum.length;
        int c=colSum.length;
        int[][] ans=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int p=Math.min(rowSum[i],colSum[j]);
                ans[i][j]=p;
                rowSum[i]-=p;
                colSum[j]-=p;
            }
        }
        return ans;
    }
}