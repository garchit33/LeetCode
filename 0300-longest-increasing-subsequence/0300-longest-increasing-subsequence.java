class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int count = 0;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    count = Math.max(count, arr[j]);
                }
            }
            arr[i] = count+1;
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }
}