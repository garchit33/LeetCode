class Solution {
    int mod = 1_000_000_007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for(int arr[][] : dp){
            for(int d[] : arr){
                Arrays.fill(d, -1);
            }
        }
        return find(m, n, maxMove, startRow, startColumn,dp);
    }

    private int find(int m, int n, int maxMove, int startRow, int startColumn, int[][][] dp){
        if(startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n)
            return 1;

        if(maxMove<=0)
            return 0;
        
        if(dp[startRow][startColumn][maxMove] != -1)
            return dp[startRow][startColumn][maxMove];

        int up = find(m,n,maxMove-1,startRow-1,startColumn,dp);
        int down = find(m,n,maxMove-1,startRow+1,startColumn,dp);
        int left = find(m,n,maxMove-1,startRow,startColumn-1,dp);
        int right = find(m,n,maxMove-1,startRow,startColumn+1,dp);

        return dp[startRow][startColumn][maxMove] = ((left+right)%mod+(up+down)%mod)%mod;
    }
}