class Solution {
    public int missingNumber(int[] nums) {
        int[] arr = new int[nums.length+1];
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            arr[nums[i]]++; 
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                ans = i;
                break;
            }
        }
        return ans;
    }
}