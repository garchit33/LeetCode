class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //Sliding window approach
        int l = 0;
        int r = 0;
        int sum =0, ans = Integer.MAX_VALUE;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>=target){
                ans = Math.min(ans,r-l+1);
                sum-=nums[l++];
            }
            r++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}