class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int ans = 0;
        for(int i=2; i<nums.length; i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                count++;
                ans += count;
            }else {
                count = 0;
            }
        }
        return ans;        
    }
}