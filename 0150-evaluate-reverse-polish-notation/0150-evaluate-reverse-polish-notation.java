class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String str : tokens){
            if(str.equals("+")){
                int sum = stack.pop() + stack.pop();
                stack.push(sum);
            }else if(str.equals("-")){
                int sum = -stack.pop() + stack.pop();
                stack.push(sum);
            }else if(str.equals("*")){
                int sum = stack.pop() * stack.pop();
                stack.push(sum);
            }else if(str.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                int sum = b/a;
                stack.push(sum);
            }else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}