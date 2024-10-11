class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(stack.size() == 0){
                return false;
            }else {
                if(c == ')' && stack.peek() != '(')
                    return false;
                if(c == ']' && stack.peek() != '[')
                    return false;
                if(c == '}' && stack.peek() != '{')
                    return false;
                
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}