class Solution {
    public int longestArithSeqLength(int[] nums) {
        int ans=0;
        HashMap<Integer, Integer>[] map = new HashMap[nums.length];

        for(int i=0; i<nums.length; i++){
            map[i] = new HashMap<>();
            for(int j=0; j<i; j++){
                int diff = nums[i]-nums[j];
                map[i].put(diff, map[j].getOrDefault(diff,1)+1);
                ans = Math.max(ans, map[i].get(diff));
            }
        }

        return ans;
    }
}