// class Solution {
//     public double average(int[] salary) {
//         // int min = Integer.MAX_VALUE;
//         // int max = Integer.MIN_VALUE;
//         // for(int i : salary){
//         //     min = Math.min(i, min);
//         //     max = Math.max(i, max);
//         // }

//     }
// }

class Solution {
    public double average(int[] salary) {
        // Sort the salary array in ascending order
        Arrays.sort(salary);
        
        // Compute the sum of all salaries
        double sum = 0;
        for(int i = 0; i < salary.length; i++) {
            sum = sum + salary[i];
        }
        
        // Return the average of salaries excluding the minimum and maximum
        // by subtracting the two extreme salaries from the sum and dividing
        // by the count of salaries minus two
        return (sum - (salary[0] + salary[salary.length - 1])) / (salary.length - 2);
    }
}