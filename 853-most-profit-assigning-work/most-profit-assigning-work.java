class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sum=0,k=0;
        int n=difficulty.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(difficulty[i])){
                map.put(difficulty[i],Math.max(profit[i],map.get(difficulty[i])));
            }
            else
            map.put(difficulty[i],profit[i]);

        }
        Arrays.sort(worker);
        Arrays.sort(difficulty);
        PriorityQueue<Integer>max=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<worker.length;i++){
            int x=worker[i];
            while(k<n && difficulty[k]<=x){
                max.offer(map.get(difficulty[k]));
                k++;
            }
            if(!max.isEmpty())
              sum+=max.peek();
        }
        return sum;
    }
}