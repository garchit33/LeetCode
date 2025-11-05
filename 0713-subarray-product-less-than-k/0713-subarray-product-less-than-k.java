class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
        int l=0;
        int r=0;
        int ans = 0, product = 1, count = 0;
        while(r<nums.length){
            product*=nums[r++];
            count++;
            while(product >= k){
                count--;
                product/=nums[l++];
            }
            ans+=count;
        }   
        return ans;
    }
}