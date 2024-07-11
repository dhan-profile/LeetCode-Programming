class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(sb.length());
            }
            else if(ch == ')'){
                int start = stack.pop();
                reverse(sb,start,sb.length() - 1);
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
    public void reverse(StringBuilder rev , int start , int end){
        while(start < end){
            char temp = rev.charAt(start);
            rev.setCharAt(start++ , rev.charAt(end));
            rev.setCharAt(end-- , temp);
        }
    }
}