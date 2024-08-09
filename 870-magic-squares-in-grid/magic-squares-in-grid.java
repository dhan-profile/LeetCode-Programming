class Solution {
    int ans=0;
    public int numMagicSquaresInside(int[][] grid) {
        int  n=grid.length;
        int m=grid[0].length;

        if(n<3 || m<3)
         return 0;
        
        for(int i=0;i<=n-3;i++)
         for(int j=0;j<=n-3;j++)
          help(i,j,grid);
        
        return ans;
    }
    public void help(int x,int y,int mat[][])
    {
       int sum[]=new int[3];
       int sumcol[]=new int[3];
       boolean[] arr=new boolean[10];

       for(int i=0;i<3;i++)
        for(int j=0;j<3;j++)
        {
            //row sum
            sum[i]+=mat[x+i][y+j];
            //column sum
            sumcol[j]+=mat[x+i][y+j];
            
            //Must have valus between 1 to 9 and must be unique
            if(mat[x+i][y+j]>9 || mat[x+i][y+j]==0 || arr[mat[x+i][y+j]]==true)
             return;
            arr[mat[x+i][y+j]]=true;
        }
       
       //Row sum must be equal to Column sum
       for(int i=1;i<3;i++)
         if(sum[i]!=sum[i-1] || sum[i]!=sumcol[i] || sumcol[i]!=sumcol[i-1])
            return;
       
       int dig=mat[x][y]+mat[x+1][y+1]+mat[x+2][y+2];
       
       //Diagonals sum must be equal and equal to any of the row or sum
       if(dig!=(mat[x][y+2]+mat[x+1][y+1]+mat[x+2][y]) || dig!=sum[0])
        return;
       
       ans++;
    }
}

// class Solution {
//     public int numMagicSquaresInside(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         if (n < 3 || m < 3) return 0;
//         int cnt = 0;
//         int[][][] magicSq = {
//             {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
//             {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
//             {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
//             {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
//             {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
//             {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
//             {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
//             {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}}
//         };
//         for (int rStart = 0; rStart <= n - 3; rStart++) {
//             for (int cStart = 0; cStart <= m - 3; cStart++) {
//                 int[][] subgrid = new int[3][3];
//                 for (int i = 0; i < 3; i++) {
//                     for (int j = 0; j < 3; j++) {
//                         subgrid[i][j] = grid[rStart + i][cStart + j];
//                     }
//                 }
//                 for (int i = 0; i <= 7; i++) {
//                     if (java.util.Arrays.deepEquals(magicSq[i], subgrid)) {
//                         cnt++;
//                     }
//                 }
//             }
//         }
//         return cnt;
//     }
// }