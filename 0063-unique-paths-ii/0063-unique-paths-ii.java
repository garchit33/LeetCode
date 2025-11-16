class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)
            return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return find(obstacleGrid, 0, 0, dp); 
    }

    private int find(int[][] arr, int i, int j, int[][] dp) {
        if(i >= arr.length || j>=arr[0].length)
            return 0;
        
        if(i == arr.length-1 && j == arr[0].length-1)
            return 1;
        
        if(dp[i][j] != -1)
            return dp[i][j];
       
        if(arr[i][j] != 1){
            return dp[i][j] = find(arr, i, j+1, dp) + find(arr, i+1, j, dp);
        }

        return 0;
    }
}