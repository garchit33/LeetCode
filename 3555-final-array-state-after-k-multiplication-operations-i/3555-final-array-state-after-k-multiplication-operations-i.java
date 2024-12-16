class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int i=0; i<nums.length; i++){
            pq.offer(new int[]{nums[i], i});
        }
        while(k>0){
            int[] rm = pq.poll();
            pq.offer(new int[]{rm[0]*multiplier, rm[1]});
            k--;
        }
        int[] ans = new int[nums.length];
        while(pq.size()>0){
            int[] rm = pq.poll();
            ans[rm[1]] = rm[0];
        }
        return ans;
    }
}