class Solution {
    public String longestPalindrome(String s) {
        int maxLen = Integer.MIN_VALUE;
        int sp = 0;
        int[][] dp = new int[s.length()][s.length()];
        for(int[] d : dp)
            Arrays.fill(d, -1);
            
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(find(s, i, j, dp) == 1){
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp+maxLen);
    }

    private int find(String s, int i, int j, int[][] dp) {
        if(i >= j)
            return 1;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j))
            return dp[i][j] = find(s, i+1, j-1, dp);
        
        return dp[i][j] = 0;
    }

}