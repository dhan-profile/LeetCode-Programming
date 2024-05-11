class Solution {
    public String tictactoe(int[][] moves) {
         LinkedList<String> list1 = new LinkedList<>();
         for (int i = (moves.length % 2 == 0)? 1 : 0; i < moves.length; i += 2) 
         {
            list1.add(moves[i][0] + "" + moves[i][1]);
         }
         
        if (
                    (list1.contains("00") && list1.contains("11") && list1.contains("22"))
                || (list1.contains("02") && list1.contains("11") && list1.contains("20"))
                || (list1.contains("00") && list1.contains("10") && list1.contains("20"))
                || (list1.contains("01") && list1.contains("11") && list1.contains("21"))
                || (list1.contains("02") && list1.contains("12") && list1.contains("22"))
                || (list1.contains("00") && list1.contains("01") && list1.contains("02"))
                || (list1.contains("10") && list1.contains("11") && list1.contains("12"))
                || (list1.contains("20") && list1.contains("21") && list1.contains("22"))
        ) {
            return (moves.length % 2 == 0) ? "B" : "A";
        }
       return (moves.length == 9)? "Draw" :"Pending";
    }
}