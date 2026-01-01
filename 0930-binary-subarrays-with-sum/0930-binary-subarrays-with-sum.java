class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums, goal) - solve(nums, goal-1);
    }

    private int solve(int[] nums, int goal){
        int sum = 0;
        int l=0, r=0, count = 0;
        
        if (goal < 0) 
            return 0;
        
        while(r < nums.length){
            sum+=nums[r];

            while(sum > goal){
                sum-=nums[l++];
            }

            count+=(r-l+1);
            r++;
        }
        return count;
    }
}