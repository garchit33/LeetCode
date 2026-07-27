class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        return solve(0, coins, amount, dp);
    }

    private int solve(int i, int[] coins, int amount, int[][] dp) {
        if(amount == 0)
            return 1;
        
        if(i == coins.length || amount < 0)
            return 0;
        
        if(dp[i][amount] != -1)
            return dp[i][amount];
        
        int take = solve(i, coins, amount-coins[i], dp);
        int notTake = solve(i+1, coins, amount, dp);

        return dp[i][amount] = take + notTake;
    }
}