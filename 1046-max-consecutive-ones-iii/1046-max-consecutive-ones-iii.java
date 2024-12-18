class Solution {
   public int longestOnes(int[] nums, int k) {
        int l=0;
        int r =0;
        int count=0;
        int ans=0;
        while(r<nums.length)
        {
            if(nums[r]==0)
                count++;
            while(count>k)
            {
                if(nums[l++]==0)
                count--;
            }
            ans=Math.max(r-l+1,ans);
            r++;
        }
        return ans;
    }
}