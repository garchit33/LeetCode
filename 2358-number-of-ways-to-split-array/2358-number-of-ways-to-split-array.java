class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] leftSum = new long[nums.length];
        long total = 0;
        for(int i=0; i<nums.length; i++){
            total+=nums[i];
            leftSum[i]=total;
        }

        long sum=0;
        int count=0;
        for(int i=nums.length-1; i>=0; i--){
            if(i==nums.length-1){
                sum += nums[i];
                continue;
            }
            
            if(leftSum[i]>=sum){
                count++;
            }
            sum+=nums[i];   
        }
        return count;
    }
}