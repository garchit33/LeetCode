class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return find(n, 0, dp);
    }

    private int find(int n , int pos, int[] dp) {
        if(pos > n)
            return 0;

        if(pos == n)
            return 1;
        
        if(dp[pos] != -1)
            return dp[pos];
        
        int way1 = find(n, pos+1, dp);
        int way2 = find(n, pos+2, dp);

        return dp[pos] = way1+way2;
    }
}