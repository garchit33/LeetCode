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
            if(par[x] == x){
                return x;
            }
            return par[x] = find(par[x]);
        }
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Dsu dsu = new Dsu(n);

        for(int i=0; i<n; i++){
            int left = leftChild[i];
            if(left != -1){
                if(dsu.find(left) != left)
                    return false;
                
                if(dsu.find(i) == left)
                    return false;
                
                dsu.union(i, left);
            }

            int right = rightChild[i];
            if(right != -1){
                if(dsu.find(right) != right)
                    return false;
                
                if(dsu.find(i) == right)
                    return false;
                
                dsu.union(i, right);
            }
        }

        int count = 0;
        for(int i=0; i<n; i++){
            if(dsu.find(i) == i){
                if(count == 1)
                    return false;
                
                count++;
            }
        }

        return true;
    }
}