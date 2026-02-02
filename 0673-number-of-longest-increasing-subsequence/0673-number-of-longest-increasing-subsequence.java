class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[][][] dp = new int[nums.length][nums.length+1][2];
        for(int[][] d : dp){
            for(int[] p : d){
                Arrays.fill(p, -1);
            }
        }

        int[] ans = find(nums, 0, -1, dp);
        return ans[1];
    }

    private int[] find(int[] nums, int idx, int pos, int[][][] dp){
        if(idx >= nums.length)
            return new int[]{0,1};
        
        if(dp[idx][pos+1][0] != -1)
            return dp[idx][pos+1];

        int notTake[] = find(nums, idx+1, pos, dp);
        int len = notTake[0];
        int count = notTake[1];

        if(pos == -1 || nums[idx] > nums[pos]){
            int take[] = find(nums, idx+1, idx, dp);
            int newLength = 1 + take[0];
            int newCount = take[1];

            if(newLength > len){
                len = newLength;
                count = newCount;
            } else if(newLength == len){
                count+=newCount;
            }
        }
        dp[idx][pos+1][0] = len;
        dp[idx][pos+1][1] = count;
        return dp[idx][pos+1];
    }
}