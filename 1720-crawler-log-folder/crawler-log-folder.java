class Solution {
    public int minOperations(String[] logs) {
        // Initialize a stack to keep track of the current directory depth
        Stack<String> stack = new Stack<>();
        
        for (String log : logs) {
            if (log.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();  // Go back one directory if possible
                }
            } else if (!log.equals("./")) {
                stack.push(log);  // Enter a new directory
            }
        }
        
        // The size of the stack represents the depth of the directory
        return stack.size();
    }
}