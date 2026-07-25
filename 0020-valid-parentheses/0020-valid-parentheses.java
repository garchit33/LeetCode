class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else if(stack.size() <= 0){
                return false;
            }else {
                if(ch == ')' && stack.peek() != '('){
                    return false;
                }
                if(ch == '}' && stack.peek() != '{'){
                    return false;
                }
                if(ch == ']' && stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size() == 0; 
    }
}