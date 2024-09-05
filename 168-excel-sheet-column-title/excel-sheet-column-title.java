class Solution {
    public String convertToTitle(int columnNumber) {
        // return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));

        // int columnNumber = 28;
        StringBuilder sb = new StringBuilder();
        while (columnNumber>0){
            int index = (columnNumber-1) %26;
            sb.insert(0,(char)('A'+ index));
            columnNumber = (columnNumber-1)/26;
        }
        return sb.toString();
    }
}