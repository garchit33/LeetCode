class Solution {
    public int minCost(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return find(nums, k, 0, dp);
    }

    private int find(int[] nums, int k, int idx, int[] dp){
        if(idx == nums.length)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];

        HashMap<Integer, Integer> map = new HashMap<>();
        int uniqueCount = 0;
        int ans = Integer.MAX_VALUE;
    
        for(int i=idx; i<nums.length; i++){
            int freq = map.getOrDefault(nums[i], 0);
            if(freq == 0)
                uniqueCount++;
            if(freq == 1)
                uniqueCount--;
            
            map.put(nums[i], freq+1);
            ans = Math.min(ans, find(nums, k, i+1, dp) + (i-idx+1-uniqueCount)+k);
        }
        return dp[idx] = ans;
    }
}