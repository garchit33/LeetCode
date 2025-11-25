class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = bfs(edges, node1);
        int[] dist2 = bfs(edges, node2);
        int max = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = 0; i < edges.length; i++) {
            int maxDist = Math.max(dist1[i], dist2[i]);
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE && maxDist < max) {
                max = maxDist;
                ans = i;
            }
        }
        return ans;
    }

    private int[] bfs(int[] edges, int src){
        int[] dist = new int[edges.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        dist[src] = 0;
        while(q.size() > 0){
            int[] rm = q.poll();
            int s = rm[0];
            int d = rm[1];
            if(edges[s] != -1 && dist[edges[s]] > d+1){
                dist[edges[s]] = d+1;
                q.offer(new int[]{edges[s], dist[edges[s]]});
            }
        }
        return dist;
    }

}