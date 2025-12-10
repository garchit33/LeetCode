class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for(int d[] : dp){
            Arrays.fill(d, -1);
        }
        return find(dungeon,0,0, dp);
    }

    private int find(int[][] arr, int i, int j, int[][] dp){
        if(i >= arr.length || j >= arr[0].length)
            return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1)
            return dp[i][j];

        if(i == arr.length-1 && j == arr[0].length-1)
            return Math.max(1, 1-arr[i][j]);
        
        int down = find(arr, i+1, j, dp);
        int right = find(arr, i, j+1, dp);

        int min = Math.min(down,right) - arr[i][j];

        return dp[i][j] = Math.max(1, min);
    }
}