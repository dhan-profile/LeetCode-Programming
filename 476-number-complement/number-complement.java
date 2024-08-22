class Solution {
    public int findComplement(int num) {
        StringBuilder inversedBinary = new StringBuilder();
        for(char c : Integer.toBinaryString(num).toCharArray()){
            if(c=='0') inversedBinary.append('1');
        else inversedBinary.append('0');
        }
        return Integer.parseInt(inversedBinary.toString(),2);
    }
}