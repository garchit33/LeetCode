class Solution {
    int mod = 1_000_000_007;
    int[][] dp;
    int[][] prefDp;
    public int numberOfSets(int n, int k) {
        dp = new int[n][k+1];
        prefDp = new int[n][k+1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(prefDp[i], -1);
        }

        return solve(n-1,k);
    }

    private int solve(int n, int k){
        if(k==0)
            return 1;
        if(n < 0)
            return 0;
        if(dp[n][k] != -1)
            return dp[n][k];
        
        long ans = solve(n-1, k);
        // for(int i=0; i<n; i++){
        //     ans += solve(n-1,k-1);
        // }
        ans = (ans + prefSum(n-1,k-1)) % mod;

        return dp[n][k] = (int) ans % mod;
    }

    private int prefSum(int n, int k){
        if(n<0)
            return 0;
        if(prefDp[n][k] != -1)
            return prefDp[n][k];
        
        long ans = prefSum(n-1, k);
        ans = (ans + solve(n,k)) % mod;
        return prefDp[n][k] = (int)ans;
    }
}