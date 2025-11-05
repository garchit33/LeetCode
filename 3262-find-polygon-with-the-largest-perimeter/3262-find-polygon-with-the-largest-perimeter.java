class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long curr = 0;
        long res = -1;
        for(int i=0; i<nums.length; i++){
            curr+=nums[i];
            if(curr > 2*nums[i])
                res=curr;
        } 
        return res;  
    }
}