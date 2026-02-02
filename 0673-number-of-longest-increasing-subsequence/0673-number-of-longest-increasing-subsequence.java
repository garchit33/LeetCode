class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        Arrays.fill(len, 1);
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        
        int maxLen = 1;
        for(int i=0; i < nums.length; i++){
            for(int j=0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(len[j]+1 > len[i]){
                        len[i] = len[j]+1;
                        count[i] = count[j];
                    } else if(len[j]+1 == len[i]){
                        count[i] += count[j];
                    }
                }
                maxLen = Math.max(maxLen, len[i]);
            }
        }

        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(len[i] == maxLen){
                ans += count[i];
            }
        }
        return ans;
    }
}