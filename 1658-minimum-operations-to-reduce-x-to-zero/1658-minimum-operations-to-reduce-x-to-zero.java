class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }

        int l=0, r=0;
        int curSum = 0;
        int maxLength = -1;
        while(r < nums.length){
            curSum += nums[r];

            while(l<=r && curSum > sum-x){
                curSum-=nums[l++];
            }

            if(curSum == sum-x){
                maxLength = Math.max(maxLength, r-l+1);
            }

            r++;
        }

        return maxLength==-1?-1:nums.length-maxLength;
    }
}