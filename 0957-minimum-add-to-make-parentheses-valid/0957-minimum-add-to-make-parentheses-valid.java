class Solution {
    public int minAddToMakeValid(String s) {
        int add = 0, remove = 0;
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(add > 0){
                    add --;
                }else {
                    remove++;
                }
            }else {
                add ++;
            }
        }
        return add + remove;
    }
}