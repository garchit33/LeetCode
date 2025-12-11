class Solution {
    public int countPalindromicSubsequences(String str) {
        int mod = 1_000_000_007;   
        int[][] dp = new int[str.length()][str.length()];

        for(int k=0; k<str.length(); k++){
            for(int i=0, j=k; j<str.length(); i++, j++){
                if(k == 0){
                    dp[i][j] = 1;
                }else if(k == 1){
                    dp[i][j] = 2;
                }else {
                    if(str.charAt(i) == str.charAt(j)){
                        int l=i+1, r=j-1;

                        while(l<=r && str.charAt(i) != str.charAt(l)){
                            l++;
                        }
                        while(l<=r && str.charAt(i) != str.charAt(r)){
                            r--;
                        }

                        if(l>r){
                            dp[i][j] = dp[i+1][j-1] * 2 + 2;
                        }else if(l==r){
                            dp[i][j] = dp[i+1][j-1] * 2 + 1;
                        }else {
                            dp[i][j] = dp[i+1][j-1] * 2 - dp[l+1][r-1];
                        }
                    }else {
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                    }
                }
                dp[i][j] = ((dp[i][j] % mod) + mod) % mod;
            }
        }
        return dp[0][str.length()-1] % mod;
    }
}