class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0;
        int r=0;
        while(r<nums.length){

            while(r<nums.length && nums[l]==nums[r])
            {
                r++;
            }
            l++;
            if(r == nums.length)
                return l;
            nums[l] = nums[r];
        }
        return nums.length;
    }
}