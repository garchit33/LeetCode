class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[][] queryWithIndex = new int[queries.length][2];
        for(int i=0; i<queries.length; i++){
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        Arrays.sort(queryWithIndex, (a,b) -> a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-a[0])-(b[1]-b[0]));
        int[] res = new int[queries.length];
        int j=0;
        for(int[] q : queryWithIndex){
            int ele = q[0];
            int idx = q[1];
            while(j<intervals.length && intervals[j][0] <= ele){
                pq.offer(intervals[j]);
                j++;
            }
            while(pq.size()>0 && pq.peek()[1] < ele){
                pq.poll();
            }
            res[idx] = pq.size()==0?-1 : pq.peek()[1]-pq.peek()[0]+1;
        }
        return res;
    }
}