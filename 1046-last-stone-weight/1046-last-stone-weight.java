class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int s : stones){
            pq.offer(s);
        }

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            if(x == y){
                pq.offer(0);
            }
            if(x != y)
                pq.offer(Math.abs(x-y));
        }
        return pq.poll();
    }
}