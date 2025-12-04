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

    public boolean equationsPossible(String[] equations) {
        Dsu dsu = new Dsu(26);

        for(String eq : equations){
            if(eq.charAt(1) == '!')
                continue;
            int ch1 = eq.charAt(0) - 'a';
            int ch2 = eq.charAt(3) - 'a';
            dsu.union(ch1, ch2);
        }

        for(String eq : equations){
            if(eq.charAt(1) == '=')
                continue;
            int ch1 = eq.charAt(0) - 'a';
            int ch2 = eq.charAt(3) - 'a';
            int x = dsu.find(ch1);
            int y = dsu.find(ch2);
            if(x == y)
                return false;
        }

        return true;
    }
}