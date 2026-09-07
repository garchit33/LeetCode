class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(isPalindrome(s, i, j)){
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s, int i, int j){
        if(i >= j)
            return true;
        
        if(s.charAt(i) != s.charAt(j))
            return false;

        return isPalindrome(s, i+1, j-1);
    }
}