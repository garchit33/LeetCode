class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int max = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int length = 1;

                while(set.contains(num + length)){
                    length++;
                }

                max = Math.max(max, length);
            }
        }

        return max;
    }
}