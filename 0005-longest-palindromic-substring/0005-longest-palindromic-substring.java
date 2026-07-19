class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        int maxLen = Integer.MIN_VALUE;
        int sp = 0;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(find(i, j, s, dp) == 1){
                    if(maxLen < j-i+1){
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp+maxLen);
    }

    private int find(int i, int j, String s, int[][] dp){
        if(i >= j)
            return 1;
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s.charAt(i) == s.charAt(j)){
            return find(i+1, j-1, s, dp);
        }

        return dp[i][j] = 0;
    }
}