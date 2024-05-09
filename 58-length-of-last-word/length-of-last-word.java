class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        int len = str.length;
        char[] ch = str[len-1].toCharArray();
        int sum = 0;
        for(char c: ch){
            sum += 1;
        }
        return sum;
    }
}