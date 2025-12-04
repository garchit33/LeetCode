class Solution {
    class Dsu {
        int par[];
        Dsu(int n){
            par = new int[n];
            for(int i=0; i<n; i++){
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
    public int makeConnected(int n, int[][] connections) {
        Dsu dsu = new Dsu(n);

        int totalReqConn = n-1;
        int cables = 0;
        for(int[] con : connections){
            if(!dsu.union(con[0], con[1])){
                totalReqConn--;
            }else {
                cables++;
            }
        }

        if(totalReqConn > cables)
            return -1;
        
        return totalReqConn;
    }
}