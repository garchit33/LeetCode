class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i=0; i<graph.length; i++){
            if(color[i]==-1){
                if(!checkBipartite(graph, color, i, 0)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBipartite(int[][] graph, int[] color, int src, int currColor){
        color[src] = currColor;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(q.size()>0){
            int rm = q.poll();
            for(int nbr : graph[rm]) {
                if(color[nbr] == color[rm])
                    return false;
                else if(color[nbr] == -1) {
                    color[nbr] = 1-color[rm];
                    q.offer(nbr);
                }
            }
        }
        return true;
    }
}