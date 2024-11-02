class Solution {
    public boolean isCircularSentence(String sentence) {
        String word[] = sentence.split(" ");
        
        int length = word.length;
        if(sentence.charAt(sentence.length()-1) == sentence.charAt(0)){
            for(int i=0; i<length-1; i++){
                char lastletter_of_word = word[i].charAt(word[i].length()-1);
                char firstletter_of_nextword = word[i+1].charAt(0);
                if(lastletter_of_word != firstletter_of_nextword){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
