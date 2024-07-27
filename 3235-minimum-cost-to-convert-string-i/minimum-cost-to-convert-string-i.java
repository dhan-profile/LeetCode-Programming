// class Solution {
//     public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
//         int n=cost.length;
//         int size=26;
//         long price=0;
//         int[][] dist=new int[size][size];
//         for(int i=0;i<size;i++)
//         {
//             for(int j=0;j<size;j++)
//             {
//                 if(i!=j)
//                 dist[i][j]=Integer.MAX_VALUE;
//                 else
//                 dist[i][j]=0;
//             }
//         }
//         for(int i=0;i<n;i++)
//         {
//             dist[original[i]-'a'][changed[i]-'a']=Math.min(cost[i], dist[original[i]-'a'][changed[i]-'a']);
//         }

//         for(int k=0;k<size;k++)
//         {
//             for(int i=0;i<size;i++)
//             {
//                 for(int j=0;j<size;j++)
//                 {
//                     if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE && dist[i][j]>dist[i][k]+dist[k][j])
//                     dist[i][j]=dist[i][k]+dist[k][j];
//                 }
//             }
//         }

//         for(int i=0;i<source.length();i++)
//         {
//             char c1=source.charAt(i);
//             char c2=target.charAt(i);
//             if(c1!=c2)
//             {
//                 if(dist[c1-'a'][c2-'a']==Integer.MAX_VALUE)
//                 return -1;
//                 price+=(long)dist[c1-'a'][c2-'a'];
//             }
//         }
//         return price;
//     }
// }
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            dis[original[i] - 'a'][changed[i] - 'a'] = Math.min(dis[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++)
                if (dis[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (dis[k][j] < Integer.MAX_VALUE) {
                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                        }
                    }
                }
        }
        long ans = 0L;
        for (int i = 0; i < source.length(); i++) {
            int c1 = source.charAt(i) - 'a';
            int c2 = target.charAt(i) - 'a';
            if (dis[c1][c2] == Integer.MAX_VALUE) {
                return -1L;
            } else {
                ans += (long)dis[c1][c2];
            }
        }
        return ans;
    }
}