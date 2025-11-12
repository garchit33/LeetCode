class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        vis[source] = true;
        while(q.size()>0){
            int rm = q.poll();
            if(rm == destination){
                return true;
            }
               
            for(int nbr : graph.get(rm)){
                if(!vis[nbr]){
                    q.offer(nbr);
                    vis[nbr] = true;
                }
            }
        }
        return false;
    }
}