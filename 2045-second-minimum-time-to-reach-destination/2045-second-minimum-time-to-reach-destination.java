class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int[] vis = new int[n+1];
        int[] dis = new int[n+1];
        Arrays.fill(dis, -1);
        pq.offer(new int[]{1,0});

        while(pq.size() > 0){
            int[] rm = pq.poll();
            int node = rm[0];
            int t = rm[1];

            if(dis[node] == t || vis[node] >= 2)
                continue;
            vis[node]++;
            dis[node] = t;

            if(node == n && vis[node] == 2)
                return dis[node];
            
            if(t/change % 2 != 0){
                t = (t/change + 1)*change;
            }
            for(int nbr : graph.get(rm[0])){
                pq.offer(new int[]{nbr, t+time});
            }
        }
        return -1;
    }
}