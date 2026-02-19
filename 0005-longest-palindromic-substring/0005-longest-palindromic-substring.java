class Solution {
    public String longestPalindrome(String s) {
        int maxLen = Integer.MIN_VALUE;
        int sp = 0;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(find(s, i, j) == true){
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp+maxLen);
    }

    private boolean find(String s, int i, int j){
        if(i >= j)
            return true;
        
        if(s.charAt(i) == s.charAt(j))
            return find(s, i+1, j-1);
        
        return false;
    }

}