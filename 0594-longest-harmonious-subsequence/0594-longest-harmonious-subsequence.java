class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l=0, r=0, ans=0;
        while(r<nums.length){
            while(l<r && nums[r]-nums[l]>1){
                l++;
            }
            if(nums[l]!=nums[r])
                ans = Math.max(r-l+1,ans);
            r++;
        }
        return ans;
    }
}