class Solution {
     public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5)  //if customer gives $5 then we simply take it as lemonade costs $5 
                five++;
            else if (i == 10) { //if we have $10 then we reduce number of $5 bills by one and increase $10 by one
                five--; ten++;
            }
            else if (ten > 0 && five>=1) { //if we get $20 then we first try to give back $10+$5
                ten--; five--;
            }
            else        // if we cannot give back $10+$5 then unfortunately we have to give back $5+$5+$5
                five -= 3;
            if (five < 0)  // if at any time we do not have any $5 left then we return false
                return false;
        }
        return true;
    }
        
}        