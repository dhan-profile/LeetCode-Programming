class Solution {
    public boolean judgeSquareSum(int c) {
        long rootC=(long)Math.sqrt(c);
        long a =0 , b=rootC;
        while(a<=b){
            long val = a*a + b*b;

            if(val ==c){return true;}
            else if (val > c){
                b--;
            }else{
                a++;
            }
        }
        return false;
    }
   
}