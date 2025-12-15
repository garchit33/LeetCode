class Solution {
    public long getDescentPeriods(int[] prices) {
        long[] dp = new long[prices.length];
        Arrays.fill(dp,1);
        
        for(int i=1; i<prices.length; i++){
            if(prices[i-1] - prices[i] == 1){
                dp[i] = dp[i-1] + 1;
            }
        }

        long sum = Arrays.stream(dp).sum();
        return sum;
    }
}