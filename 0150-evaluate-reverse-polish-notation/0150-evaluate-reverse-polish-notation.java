class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(String str : tokens){
            if(str.equals("+")){
                res = stack.pop() + stack.pop();
                stack.push(res);
            }else if(str.equals("-")){
                res = -stack.pop() + stack.pop();
                stack.push(res);
            }else if(str.equals("*")){
                res = stack.pop() * stack.pop();
                stack.push(res);
            }else if(str.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                res = b/a;
                stack.push(res);
            }else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}