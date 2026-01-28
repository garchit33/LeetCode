class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        
        for(int i=1; i<heights.length; i++){
            if(heights[i]-heights[i-1]>0){
                pq.offer(heights[i]-heights[i-1]);

                while(pq.size() > ladders){
                    bricks -= pq.poll();
                }

                if(bricks < 0)
                    return i-1;
            }
        }
        return heights.length-1;
    }
}