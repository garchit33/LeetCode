class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        // for(Boolean[] d: dp){
        //     Arrays.fill()
        // }

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(isPalindrome(s, i, j, dp)){
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s, int i, int j, Boolean[][] dp){
        if(i >= j)
            return true;
        
        if(dp[i][j] != null)
            return dp[i][j];

        if(s.charAt(i) != s.charAt(j))
            return false;

        return dp[i][j] = isPalindrome(s, i+1, j-1, dp);
    }
}