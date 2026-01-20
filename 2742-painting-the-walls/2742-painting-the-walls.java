class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int[][] dp = new int[cost.length+1][time.length+1];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return find(cost, time, 0, cost.length, dp);
    }

    private int find(int[] cost, int[] time, int idx, int remaining, int[][] dp){
        if(remaining <= 0)
            return 0;
        if(idx == cost.length)
            return Integer.MAX_VALUE;
        if(dp[idx][remaining] != -1)
            return dp[idx][remaining];

        int ans = Integer.MAX_VALUE;
        ans = find(cost, time, idx+1, remaining, dp);
        int x = find(cost, time, idx+1, remaining-time[idx]-1, dp);
        x = x == Integer.MAX_VALUE ? Integer.MAX_VALUE : x + cost[idx];
        ans = Math.min(ans, x);

        return dp[idx][remaining] = ans;
    }
}