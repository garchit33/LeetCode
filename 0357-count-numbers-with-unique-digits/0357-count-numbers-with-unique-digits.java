class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        int num = 9;
        int sum = 1;
        for(int i=1; i<=n; i++){
            sum = sum * num;
            dp[i] = sum+dp[i-1];
            if(i>1)
                num--;
        }

        return dp[n];
    }
}