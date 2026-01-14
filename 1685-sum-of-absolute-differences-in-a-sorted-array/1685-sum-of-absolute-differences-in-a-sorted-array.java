class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }

        int leftSum = 0;
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int left = nums[i]*i - leftSum;
            int right = (sum - leftSum - nums[i]) - (nums.length - i - 1) * nums[i];
            leftSum += nums[i];
            ans[i] = left + right;
        }

        return ans;
    }
}