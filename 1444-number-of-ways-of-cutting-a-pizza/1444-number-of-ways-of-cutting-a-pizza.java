class Solution {
    int mod = 1_000_000_007;
    public int ways(String[] pizza, int k) {
        
        int[][] prefixSum = getPrefixSum(pizza);
        if(!hasApple(prefixSum,0,pizza.length-1,0,pizza[0].length()-1))
            return 0;

        int[][][] dp = new int[pizza.length][pizza[0].length()][k+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                for(int m=0; m<dp[0][0].length; m++){
                    dp[i][j][m] = -1;
                }
            }
        }

        return find(prefixSum,0,pizza.length,0,pizza[0].length(),k-1,dp);
    }

    private int find(int[][] prefix, int i, int m, int j, int n, int k, int[][][] dp){
        if(k==0)
            return 1;
        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }
        int horizontal=0;
        int vertical=0;
        int ans=0;
        for(int r=i+1; r<m; r++){
            if(hasApple(prefix,i,r,j,n) && hasApple(prefix,r,m,j,n)){
                horizontal = (horizontal + find(prefix,r,m,j,n,k-1,dp))%mod;
            }
        }

        for(int c=j+1; c<n; c++){
            if(hasApple(prefix,i,m,j,c) && hasApple(prefix,i,m,c,n)){
                vertical = (vertical + find(prefix,i,m,c,n,k-1,dp))%mod;
            }
        }

        return dp[i][j][k] = ans = (horizontal + vertical)%mod;
    }

    private boolean hasApple(int[][] prefix, int i, int m, int j, int n){
        return prefix[m][n]-prefix[i][n]-prefix[m][j]+prefix[i][j] > 0;
    }

    private int[][] getPrefixSum(String[] pizza){
        int[][] prefix = new int[pizza.length+1][pizza[0].length()+1];
        for(int i=0; i<pizza.length; i++){
            for(int j=0; j<pizza[0].length(); j++){
                prefix[i+1][j+1] = (pizza[i].charAt(j)=='A'?1:0)+prefix[i+1][j]+prefix[i][j+1]-prefix[i][j];
            }
        }
        return prefix;
    }
}