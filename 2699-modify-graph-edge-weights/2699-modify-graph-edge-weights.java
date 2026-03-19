class Solution {
    private int LARGE_VALUE = (int) 2e9;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        long currShortestDist = dijkastra(edges, n, source, destination);

        if(currShortestDist < target)
            return new int[][]{};
        
        boolean matchedTarget = (currShortestDist == target);

        for(int[] edge : edges){
            if(edge[2] == -1){
                edge[2] = (matchedTarget ? LARGE_VALUE : 1);

                if(!matchedTarget){
                    long newShortestDist = dijkastra(edges, n, source, destination);

                    if(newShortestDist <= target){
                        matchedTarget = true;
                        edge[2] += (target-newShortestDist);
                    } 
                }
            }
        }

        if(!matchedTarget)
            return new int[][]{};
        
        return edges;
    }

    private long dijkastra(int[][] edges, int n, int src, int dest){
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            if (edge[2] != -1) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                graph.get(u).add(new int[]{v, wt});
                graph.get(v).add(new int[]{u, wt});
            }
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0]));
        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE);

        pq.offer(new long[]{0, src});
        cost[src] = 0;

        while(pq.size() > 0){
            long[] rm = pq.poll();
            long currDist = rm[0];
            int currNode = (int) rm[1];

            if (currDist > cost[currNode]) 
                continue;

            for(int[] neighbour : graph.get(currNode)){
                int nbr = neighbour[0];
                int wt = neighbour[1];

                if(currDist + wt < cost[nbr]){
                    cost[nbr] = currDist + wt;
                    pq.offer(new long[]{cost[nbr], nbr});
                }
            }
        }

        return cost[dest];
    }
}