class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);

        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                if(!bfs(graph, color, i))
                    return false;
            }
        }

        return true;
    }

    private boolean bfs(int[][] graph, int[] color, int src){
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        color[src] = 0;
        while(q.size()>0){
            int rm = q.poll();
            for(int nbr : graph[rm]){
                if(color[nbr] == -1){
                    q.offer(nbr);
                    color[nbr] = 1-color[rm];
                }else if(color[nbr] == color[rm]){
                    return false;
                }
            }
        }
        return true;
    }
}