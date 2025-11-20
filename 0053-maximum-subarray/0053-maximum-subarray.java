class Solution {
    public int maxSubArray(int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        while(r < nums.length){
            sum+=nums[r++];
            ans = Math.max(ans, sum);
            while(sum<0)
                sum-=nums[l++];
        }
        return ans;
    }
}