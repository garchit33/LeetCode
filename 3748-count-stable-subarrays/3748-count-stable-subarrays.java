class Solution {
    public long[] countStableSubarrays(int[] nums, int[][] queries) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for(int i=1; i<nums.length; i++){
            if(nums[i]>=nums[i-1]){
                left[i] = left[i-1];
            }else {
                left[i] = i;
            }
        }
        
        right[nums.length-1] = nums.length-1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] <= nums[i+1]){
                right[i] = right[i+1];
            }else {
                right[i] = i;
            }
        }

        long[] dp = new long[nums.length];
        dp[0]=1;
        for(int i=1; i<nums.length; i++){
            int start = left[i];
            long len = i-start+1;
            dp[i] = len*(len+1)/2;
            if(start!=0)
                dp[i]+=dp[start-1];
        }

        long[] ans = new long[queries.length];
        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            long res = dp[end];
            if(start>0)
                res-=dp[start-1];
            res-=(long) (start-left[start])*(Math.min(right[start],end)-start+1);
            ans[i] = res;
        }
        return ans;
    }
}