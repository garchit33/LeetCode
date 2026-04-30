class Solution {
    int n;
    long[][][] dp;

    public long maximumScore(int[][] grid) {
        dp = new long[2][101][101];
        for(int i=0; i<2; i++){
            for(int j=0; j<101; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        n = grid.length;
        long[][] colPrefSum = new long[n+1][n+1];

        for(int col = 1; col <= n; col++){
            for(int row = 1; row <= n; row++){
                colPrefSum[row][col] = colPrefSum[row-1][col] + grid[row-1][col-1];
            }
        }

        return solve(false, 0, 0, grid, colPrefSum);
    }

    // prevHeight - Height from top till grid[i][j] is black
    private long solve(boolean prevTaken, int prevHeight, int col, int[][] grid, long[][] colPrefSum) {
        if(col == n){
            return 0;
        }

        if(dp[prevTaken ? 1:0][prevHeight][col] != -1){
            return dp[prevTaken ? 1:0][prevHeight][col];
        }

        long result = 0;
        
        for(int height =0; height <=n; height++){
            long prevColScore = 0;
            long curColScore = 0;

            if(!prevTaken && col > 0 && height > prevHeight){
                // prevColScore = colPrefSum[height][[col-1]+1] + colPrefSum[prevHeight][[col-1]+1]; 
                // (Adding +1 because colPrefSum is of [n+1][n+1]) to avoid boundry cases
                prevColScore = colPrefSum[height][col] - colPrefSum[prevHeight][col];
            }

            if(height < prevHeight){
                curColScore = colPrefSum[prevHeight][col+1] - colPrefSum[height][col+1];
            }

            long currColScoreTaken = curColScore + prevColScore + solve(true, height, col+1, grid, colPrefSum);
            long currColScoreNotTaken = prevColScore + solve(false, height, col+1, grid, colPrefSum);

            result = Math.max(result, Math.max(currColScoreTaken, currColScoreNotTaken));
        }

        return dp[prevTaken ? 1:0][prevHeight][col] = result;
    }
}