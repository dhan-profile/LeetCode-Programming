class Solution {
    public int findTheCity(int n, int[][] edges, int disThr) {
        int[] distance=new int[n];
        int[] counter=new int[n];

        for(int src=0;src<n;src++){ //for each city as source
            Arrays.fill(distance, 100000000);
            distance[src]=0;
            for(int iter=0;iter<n;iter++){ // for each city, iterate n-1 times

                for(int [] arr: edges){
                    int u=arr[0];
                    int v=arr[1];
                    int wt=arr[2];

                    if(distance[u]!=100000000 && distance[u]+wt<distance[v]){
                        distance[v]=distance[u]+wt;
                    }
                    if(distance[v]!=100000000 && distance[v]+wt<distance[u]){
                        distance[u]=distance[v]+wt;
                    }
                }
            }
            for(int i=0;i<n;i++){
                if(i!=src && distance[i]<=disThr){
                    counter[src]++;
                }
            }
        }
      
        int res=0;
        int highPath=100000000;
        for(int i=0;i<n;i++){
            if(counter[i]<=highPath){
                highPath=counter[i];
                res=i;
            }
        }
return res;
    }
}