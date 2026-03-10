class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(int key : map.keySet()){
            pq.offer(new int[]{key, map.get(key)});
        }

        while(pq.size() > k){
            pq.poll();
        }

        int[] ans = new int[k];
        int x = 0;
        while(pq.size()>0){
            ans[x++] = pq.poll()[0];
        }

        return ans;
    }
}