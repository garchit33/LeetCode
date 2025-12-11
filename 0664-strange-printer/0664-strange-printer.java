class Solution {
    public int strangePrinter(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int d[] : dp)
            Arrays.fill(d, -1);

        return find(s, 0, s.length()-1, dp);
    }

    private int find(String s, int i, int j, int[][] dp){
        if(i > j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];
        
        // Current character is not repeated in the rest of the string
        int ans = 1 + find(s, i+1, j, dp);
        for(int k=i+1; k<=j; k++){
             // if repeated then update the answer
            if(s.charAt(k) == s.charAt(i)){
                int skip = find(s,i,k-1,dp) + find(s,k+1,j,dp);
                ans = Math.min(skip,ans);
            }
        }
        return dp[i][j] = ans;
    }
}
