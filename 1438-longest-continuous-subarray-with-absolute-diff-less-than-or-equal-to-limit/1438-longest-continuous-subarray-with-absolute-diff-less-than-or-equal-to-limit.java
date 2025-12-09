class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> max = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int l=0; 
        int r=0;
        int ans = 0;

        while(r < nums.length){
            max.offer(new int[]{r, nums[r]});
            min.offer(new int[]{r, nums[r]});

            while(max.peek()[1] - min.peek()[1] > limit){
                l = Math.min(max.peek()[0], min.peek()[0])+1;
                while(max.peek()[0] < l)
                    max.poll();
                while(min.peek()[0] < l)
                    min.poll();
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}