class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<num.length();i++){
            while(stack.size()>0 && k>0 && stack.peek()-'0' > num.charAt(i)-'0'){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(stack.size()>0 && k>0){
            stack.pop();
            k--;
        }

        StringBuilder str = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        while(stack.size() > 0){
            char ch = stack.pop();
            if(ch == '0'){
                str.append(ch);
            }else {
                ans.append(str);
                ans.append(ch);
                str = new StringBuilder();
            }
        }
        String res = ans.reverse().toString();
        return res.equals("")?"0":res;
    }
}