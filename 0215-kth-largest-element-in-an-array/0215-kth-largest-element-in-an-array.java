class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int num : nums){
            pq.offer(num);
        }

        if(pq.size() < k)
            return -1;
        
        while(k>1){
            int ans =pq.poll();
            k--;
        }
        return pq.poll();
    }
}