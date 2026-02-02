class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int i=0, j=n;
        for(int k=0; k<nums.length; k++){
            ans[k++] = nums[i++];
            ans[k] = nums[j++];
        }
        return ans;
    }
}