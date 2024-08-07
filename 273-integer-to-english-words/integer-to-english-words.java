class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        int i = 0;
        StringBuilder words = new StringBuilder();
        
        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder currentSegment = new StringBuilder();
                helper(currentSegment, num % 1000);
                words.insert(0, currentSegment.append(THOUSANDS[i]).append(" "));
            }
            num /= 1000;
            i++;
        }
        
        return words.toString().trim();
    }
    
    private void helper(StringBuilder segment, int num) {
        if (num == 0) return;
        if (num < 20) {
            segment.append(LESS_THAN_20[num]).append(" ");
        } else if (num < 100) {
            segment.append(TENS[num / 10]).append(" ");
            helper(segment, num % 10);
        } else {
            segment.append(LESS_THAN_20[num / 100]).append(" Hundred ");
            helper(segment, num % 100);
        }
    }
}

// class Solution {
//     public String numberToWords(int num) {
//         String[] to19 = "One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Eleven,Twelve,Thirteen,Fourteen,Fifteen,Sixteen,Seventeen,Eighteen,Nineteen".split(",");
//         String[] tens = "Twenty,Thirty,Forty,Fifty,Sixty,Seventy,Eighty,Ninety".split(",");

//         String words(int n) {
//             if (n < 20) return to19[n - 1];
//             if (n < 100) return tens[n / 10 - 2] + (n % 10 > 0 ? " " + words(n % 10) : "");
//             if (n < 1000) return words(n / 100) + " Hundred" + (n % 100 > 0 ? " " + words(n % 100) : "");
//             String[] units = {"", "Thousand", "Million", "Billion"};
//             int i = 0;
//             while (n >= 1000) {
//                 if (n % 1000 != 0) {
//                     return words(n / 1000) + " " + units[i] + (n % 1000 > 0 ? " " + words(n % 1000) : "");
//                 }
//                 n /= 1000;
//                 i++;
//             }
//             return words(n) + " " + units[i];
//         }

//         return num == 0 ? "Zero" : words(num);
//     }
// }