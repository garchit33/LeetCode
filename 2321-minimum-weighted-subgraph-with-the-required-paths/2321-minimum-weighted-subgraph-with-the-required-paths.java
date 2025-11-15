class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<int[]>> srctoDest = new ArrayList<>();
        List<List<int[]>> destToSrc = new ArrayList<>();
        buildGraph(n, edges, srctoDest, destToSrc);

        long[] fromSrc1 = new long[n];
        long[] fromSrc2 = new long[n];
        long[] fromDest = new long[n];

        Arrays.fill(fromSrc1, Long.MAX_VALUE);
        Arrays.fill(fromSrc2, Long.MAX_VALUE);
        Arrays.fill(fromDest, Long.MAX_VALUE);

        shortestPath(src1, fromSrc1, srctoDest);
        shortestPath(src2, fromSrc2, srctoDest);
        shortestPath(dest, fromDest, destToSrc);

        long ans = Long.MAX_VALUE;
        for(int i=0; i<n; i++){
            long d1 = fromSrc1[i], d2 = fromSrc2[i], d3 = fromDest[i];
            if(d1 != Long.MAX_VALUE && d2 != Long.MAX_VALUE && d3 != Long.MAX_VALUE)
                ans = Math.min(ans,d1+d2+d3);
        }

        return ans == Long.MAX_VALUE?-1:ans;
    }

    private void buildGraph(int n, int[][] edges, List<List<int[]>> graph1, List<List<int[]>> graph2){
        for(int i=0; i<n; i++){
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph1.get(edge[0]).add(new int[]{edge[1],edge[2]});
            graph2.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
    }

    private void shortestPath(int src, long[] arr, List<List<int[]>> graph){
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[1],b[1]));
        pq.offer(new long[]{src, 0});
        // arr[src] = 0;

        while(pq.size()>0){
            long[] rm = pq.poll();
            int x = (int) rm[0];
            long wt = rm[1];
            if (arr[x] != -1 && arr[x] <= wt) 
                continue;
            arr[x] = wt;
            for(int nbr[] : graph.get(x)){
                // if(arr[nbr[0]] > wt + nbr[1]){
                    pq.offer(new long[]{nbr[0], wt + nbr[1]});
                    // arr[nbr[0]] = wt + nbr[1]; 
                // }
            }
        }
    }

}