class Solution {
    public int countSeniors(String[] details) {
        int no_of_passangers = 0;
        for(String det : details){
            // int num = (int) det.substring(11,13);
            int age = Integer.parseInt(det.substring(11, 13));
            if(age > 60){
                no_of_passangers += 1;
            }
        }
        return no_of_passangers;
    }
}