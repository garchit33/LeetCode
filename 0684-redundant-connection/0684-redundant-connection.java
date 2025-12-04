class Solution {
    class Dsu {
        int par[];
        Dsu(int n){
            par = new int[n+1];
            for(int i=0; i<=n; i++){
                par[i] = i;
            }
        }

        public boolean union(int x, int y){
            int u = find(x);
            int v = find(y);

            if(u == v)
                return true;
            
            par[v] = par[u];
            return false;
        }

        public int find(int x){
            if(par[x] == x)
                return x;

            return par[x] = find(par[x]);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        Dsu dsu = new Dsu(edges.length);
        int n = edges.length;

        for(int edge[] : edges){
            if(dsu.union(edge[0], edge[1]))
                return edge;
        }

        return edges[n-1];
    }
}