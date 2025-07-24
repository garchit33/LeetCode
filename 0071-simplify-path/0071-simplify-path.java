class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for(String str : split){
            if(str.equals(""))
                continue;
            else if(str.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else if(str.equals("."))
                continue;
            else
                stack.push(str);
        }

        String ans = "";
        while(!stack.isEmpty()){
            ans = "/"+stack.pop()+ans;
        }

        if(ans.equals(""))
            return "/";
        
        return ans;
    }
}