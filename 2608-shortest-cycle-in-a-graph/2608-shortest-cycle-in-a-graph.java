class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int minCycle = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            dist[i] = 0;
            
            while(q.size() > 0){
                int rm = q.poll();

                for(int nbr : graph.get(rm)){
                    if(dist[nbr] == -1){
                        dist[nbr] = dist[rm] + 1;
                        q.offer(nbr);
                    }else if(nbr != i && dist[nbr] >= dist[rm]) {
                        minCycle = Math.min(minCycle, dist[rm] + dist[nbr] + 1);
                    }
                }
            }
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}