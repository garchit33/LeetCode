class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[] : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        q.offer(new int[]{k, 0});
        
        while(q.size() > 0){
            int[] rm = q.poll();
            int src = rm[0];
            int wt = rm[1];
            for(int[] nbr : graph.get(src)){
                if(wt + nbr[1] < dist[nbr[0]]){
                    dist[nbr[0]] = wt + nbr[1];
                    q.offer(new int[]{nbr[0], dist[nbr[0]]});
                }
            }
        }

        int ans = 0;
        for(int i = 1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}