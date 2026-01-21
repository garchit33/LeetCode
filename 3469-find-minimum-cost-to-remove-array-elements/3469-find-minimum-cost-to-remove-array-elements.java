class Solution {
    public int minCost(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] d : dp)
            Arrays.fill(d, -1);

        return find(nums, 0, 1, dp);
    }

    private int find(int[] arr, int first, int sec, int[][] dp){
        if(sec >= arr.length)
            return arr[first];
        if(sec == arr.length-1)
            return Math.max(arr[first], arr[sec]);

        if(dp[first][sec] != -1)
            return dp[first][sec];

        int ans = Integer.MAX_VALUE;
        
        ans = Math.min(ans, Math.max(arr[sec], arr[sec+1]) + find(arr, first, sec+2, dp));
        ans = Math.min(ans, Math.max(arr[first], arr[sec]) + find(arr, sec+1, sec+2, dp));
        ans = Math.min(ans, Math.max(arr[first], arr[sec+1]) + find(arr, sec, sec+2, dp));
        
        return dp[first][sec] = ans;
    }
}