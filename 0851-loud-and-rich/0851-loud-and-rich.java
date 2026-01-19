class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<quiet.length; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] r : richer){
            graph.get(r[1]).add(r[0]);
        }

        int[] ans = new int[quiet.length];
        for(int i=0; i<quiet.length; i++){
            ans[i]=i;
        }

        boolean[] vis = new boolean[quiet.length];
        for(int i=0; i<quiet.length; i++){
            if(!vis[i]){
                dfs(graph, vis, quiet, ans, i);
            }
        }

        return ans;
    }

    private int dfs(List<List<Integer>> graph, boolean[] vis, int[] quiet, int[] ans, int src){
        if(vis[src])
            return ans[src];
        
        vis[src] = true;

        for(int nbr : graph.get(src)){
            int val = dfs(graph, vis, quiet, ans, nbr);
            if(quiet[val] < quiet[ans[src]]){
                ans[src] = val;
            }
        }

        return ans[src];
    }
}