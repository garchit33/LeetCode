class Solution {
    public int minPathSum(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return find(arr, 0, 0, dp);
    }

    private int find(int[][] arr, int i, int j, int[][] dp){
        if(i>=arr.length || j>=arr[0].length){
            return 9999999;
        }
        if(i == arr.length-1 && j == arr[0].length-1){
            return arr[i][j];
        }
        if(dp[i][j] != -1)
            return dp[i][j];

        int res1 = find(arr, i, j+1, dp); 
        int res2 = find(arr, i+1, j, dp);
        
        return dp[i][j] = Math.min(res1, res2) + arr[i][j];
    }
}