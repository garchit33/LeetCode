class Solution {
    public int waysToMakeFair(int[] nums) {
        int totalEven = 0;
        int totalOdd = 0;
        for(int i=0; i<nums.length; i++){
            if((i & 1) == 0)
                totalEven += nums[i];
            else
                totalOdd += nums[i];
        }

        int leftOdd = 0;
        int leftEven = 0;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if((i & 1) == 0)
                totalEven-=nums[i];
            else
                totalOdd-=nums[i];
            
            if(leftOdd + totalEven == leftEven + totalOdd){
                ans++;
            }

            if((i & 1) == 0)
                leftEven+=nums[i];
            else
                leftOdd+=nums[i];
        }

        return ans;
    }
}