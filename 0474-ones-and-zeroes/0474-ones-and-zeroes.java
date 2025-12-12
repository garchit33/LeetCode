class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] arr = new int[strs.length][2];

        for(int i=0; i<strs.length; i++){
            int cntz=0, cnto=0;
            for(char ch : strs[i].toCharArray()){
                if(ch == '0')
                    cntz++;
                else
                    cnto++;
            }
            arr[i][0] = cntz;
            arr[i][1] = cnto;
        }

        int dp[][][] = new int[strs.length][m+1][n+1];
        for(int i=0; i<strs.length; i++){
            for(int j=0; j<=m; j++){
                for(int k=0; k<=n; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return find(arr, 0, m, n, dp);
    }

    private int find(int[][] arr, int pos, int m, int n, int[][][] dp){
        if(pos == arr.length)
            return 0;
        
        if(dp[pos][m][n] != -1)
            return dp[pos][m][n];

        int notTake = find(arr, pos+1, m, n, dp);
        int take = 0;
        if(m-arr[pos][0]>=0 && n-arr[pos][1]>=0){
            take = 1+find(arr, pos+1, m-arr[pos][0], n-arr[pos][1], dp);
        }

        return dp[pos][m][n] = Math.max(take, notTake);
    }
}