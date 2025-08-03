class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp = new double[nums.length][k+1];
        for(double[] arr : dp)
            Arrays.fill(arr, -1);
        return find(nums, k, 0, dp);
    }

    private double find(int[] nums, int k, int pos, double[][] dp){
        if(pos == nums.length)
            return 0;
        if(dp[pos][k]!=-1)
            return dp[pos][k];
        if(k==1){
            double sum = 0;
            int count = 0;
            for(int i=pos; i<nums.length; i++){
                sum += nums[i];
                count++;
            }
            return dp[pos][k] = sum/count;
        }

        double sum = 0;
        int count = 0;
        double ans = 0;
        for(int i=pos; i<nums.length; i++){
            sum+=nums[i];
            count++;
            double avg = (sum/count) + find(nums, k-1, i+1, dp);
            ans = Math.max(ans,avg);
        } 

        return dp[pos][k] = ans;
    }
}