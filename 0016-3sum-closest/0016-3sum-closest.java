class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-1; i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(Math.abs(nums[i]+nums[j]+nums[k]-target) < min){
                    min = Math.abs(nums[i]+nums[j]+nums[k]-target);
                    ans = nums[i]+nums[j]+nums[k];
                }

                if(target-(nums[i]+nums[j]+nums[k]) > 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return ans;
    }
}