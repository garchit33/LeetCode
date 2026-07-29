class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        for(boolean[] d : dp){
            Arrays.fill(d, false);
        }
        return find(0,0,s,p,dp);
    }

    private boolean find(int i, int j, String text, String pattern, boolean[][] dp) {
        if(dp[i][j] != false){
            return dp[i][j];
        }
        boolean ans;
        if(j == pattern.length()){
            ans = i == text.length();
        }else {
            boolean firstMatch = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

            if(j+1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (find(i, j+2, text, pattern, dp) || firstMatch && find(i+1, j, text, pattern, dp));
            }else {
                ans = firstMatch && find(i+1, j+1, text, pattern, dp);
            }
        }
        return dp[i][j] = ans;
    }
}