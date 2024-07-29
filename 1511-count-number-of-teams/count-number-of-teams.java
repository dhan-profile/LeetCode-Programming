// class Solution {

//     public int numTeams(int[] rating) {
//         int n = rating.length;
//         int teams = 0;
//         Integer[][] increasingCache = new Integer[n][4];
//         Integer[][] decreasingCache = new Integer[n][4];

//         // Calculate total teams by considering each soldier as a starting point
//         for (int startIndex = 0; startIndex < n; startIndex++) {
//             teams +=
//             countIncreasingTeams(rating, startIndex, 1, increasingCache) +
//             countDecreasingTeams(rating, startIndex, 1, decreasingCache);
//         }

//         return teams;
//     }

//     private int countIncreasingTeams(
//         int[] rating,
//         int currentIndex,
//         int teamSize,
//         Integer[][] increasingCache
//     ) {
//         int n = rating.length;

//         // Base case: reached end of array
//         if (currentIndex == n) return 0;

//         // Base case: found a valid team of size 3
//         if (teamSize == 3) return 1;

//         // Return cached result if available
//         if (increasingCache[currentIndex][teamSize] != null) {
//             return increasingCache[currentIndex][teamSize];
//         }

//         int validTeams = 0;

//         // Recursively count teams with increasing ratings
//         for (int nextIndex = currentIndex + 1; nextIndex < n; nextIndex++) {
//             if (rating[nextIndex] > rating[currentIndex]) {
//                 validTeams +=
//                 countIncreasingTeams(
//                     rating,
//                     nextIndex,
//                     teamSize + 1,
//                     increasingCache
//                 );
//             }
//         }

//         // Cache and return the result
//         return increasingCache[currentIndex][teamSize] = validTeams;
//     }

//     private int countDecreasingTeams(
//         int[] rating,
//         int currentIndex,
//         int teamSize,
//         Integer[][] decreasingCache
//     ) {
//         int n = rating.length;

//         // Base case: reached end of array
//         if (currentIndex == n) return 0;

//         // Base case: found a valid team of size 3
//         if (teamSize == 3) return 1;

//         // Return cached result if available
//         if (decreasingCache[currentIndex][teamSize] != null) {
//             return decreasingCache[currentIndex][teamSize];
//         }

//         int validTeams = 0;

//         // Recursively count teams with decreasing ratings
//         for (int nextIndex = currentIndex + 1; nextIndex < n; nextIndex++) {
//             if (rating[nextIndex] < rating[currentIndex]) {
//                 validTeams +=
//                 countDecreasingTeams(
//                     rating,
//                     nextIndex,
//                     teamSize + 1,
//                     decreasingCache
//                 );
//             }
//         }

//         // Cache and return the result
//         return decreasingCache[currentIndex][teamSize] = validTeams;
//     }
// }

class Solution {
    public int numTeams(int[] rating) {
        
        int countTeams = 0;
        
        for (int i = 0; i < rating.length; i++) {
            int lesserCount = 0;
            int greaterCount = 0;
            
            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) {
                    ++lesserCount;
                }
            }
            
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    ++greaterCount;
                }
            }
            
            countTeams += lesserCount * greaterCount;
            countTeams += (i - lesserCount) * (rating.length - 1 - i - greaterCount);
        }
        
        return countTeams;
    }
}