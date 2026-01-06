class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);

        int sum = 0, count = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];

            if(set.contains(sum - target)){
                count++;
                set.clear();
                set.add(0);
                sum = 0;
            }else {
                set.add(sum);
            }
        }
        return count;
    }
}