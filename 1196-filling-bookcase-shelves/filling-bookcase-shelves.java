class Solution {
    public static int find(int books[][],int idx,int sw,int dp[]){
        if(idx>=books.length)return 0;
        int ans=(int)1e9;
        if(dp[idx]!=-1)return dp[idx];
        int cur=0;
        int width=0;
        for(int i=idx;i<books.length&&width+books[i][0]<=sw;i++){
            cur=Math.max(cur,books[i][1]);
            width+=books[i][0];
            int val=find(books,i+1,sw,dp);
            ans=Math.min(ans,cur+val);
        }
        dp[idx]=ans;
        return ans;
    }

    public int minHeightShelves(int[][] books, int sw) {
        int n = books.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return find(books, 0, sw, dp);
    }
}