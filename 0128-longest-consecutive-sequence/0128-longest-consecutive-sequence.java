class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num :nums){
            set.add(num);
        }

        // int len = 0;
        int max = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                 int len = 1;
            
                while(set.contains(num+len)){
                    len++;
                }

                max = Math.max(max,len);
            }
        }
        return max;
    }
}