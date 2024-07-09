// class Solution {
//     public double averageWaitingTime(int[][] customers) {
//         long avgTime = 0, totalTime = 0;
//         for(int i=0; i<customers.length; i++){
//             if(totalTime < customers[i][0]){
//                 totalTime = customers[i][0] + customers[i][1];
//             }
//             else {
//                 totalTime += customers[i][1];
//             }
//                 long waitTime = totalTime - customers[i][0];
//                 avgTime += waitTime;
//             }
//         }
//     return (double)avgTime/customers.length;
// }
class Solution {
    public double averageWaitingTime(int[][] customers) {
        long avgSum = 0;
        long totalTime = 0;
        for(int i = 0; i<customers.length; i++){
            if(totalTime < customers[i][0]) totalTime = customers[i][0] + customers[i][1];
            else totalTime += customers[i][1];
            long waitTime = totalTime - customers[i][0];
            avgSum += waitTime;
        }
        return (double)avgSum/customers.length;
    }
}