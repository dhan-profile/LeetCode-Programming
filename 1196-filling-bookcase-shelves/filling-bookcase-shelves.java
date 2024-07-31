// class Solution {
//     public static int find(int books[][],int idx,int sw,int dp[]){
//         if(idx>=books.length)return 0;
//         int ans=(int)1e9;
//         if(dp[idx]!=-1)return dp[idx];
//         int cur=0;
//         int width=0;
//         for(int i=idx;i<books.length&&width+books[i][0]<=sw;i++){
//             cur=Math.max(cur,books[i][1]);
//             width+=books[i][0];
//             int val=find(books,i+1,sw,dp);
//             ans=Math.min(ans,cur+val);
//         }
//         dp[idx]=ans;
//         return ans;
//     }

//     public int minHeightShelves(int[][] books, int sw) {
//         int n = books.length;
//         int dp[] = new int[n + 1];
//         Arrays.fill(dp, -1);
//         return find(books, 0, sw, dp);
//     }
// }

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return arrangeBooks(books, shelfWidth);
    }

    private int arrangeBooks(int[][] books, int maxShelfWidth) {
        int[] minHeights = new int[books.length + 1];
        
        for (int bookIndex = 1; bookIndex <= books.length; bookIndex++) {
            minHeights[bookIndex] = Integer.MAX_VALUE;
            int currentShelfHeight = 0;
            int currentShelfWidth = 0;
            
            for (int lastBook = bookIndex - 1; lastBook >= 0; lastBook--) {
                int currentBookThickness = books[lastBook][0];
                int currentBookHeight = books[lastBook][1];
                
                if (currentShelfWidth + currentBookThickness > maxShelfWidth) {
                    break;
                }
                
                currentShelfWidth += currentBookThickness;
                currentShelfHeight = Math.max(currentShelfHeight, currentBookHeight);
                
                int currentArrangementHeight = minHeights[lastBook] + currentShelfHeight;
                minHeights[bookIndex] = Math.min(minHeights[bookIndex], currentArrangementHeight);
            }
        }
        
        return minHeights[books.length];
    }
}