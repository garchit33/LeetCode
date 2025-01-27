class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }

        int count = 1;
        int dirs[][] = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(q.size()>0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] rm = q.poll();
                int x = rm[0];
                int y = rm[1];
                for(int[] dir : dirs){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(isValid(nx,ny,vis,mat)){
                        q.offer(new int[]{nx,ny});
                        vis[nx][ny]=true;
                        mat[nx][ny]=count;
                    }
                } 
            }
            count++;
        }
        return mat;
    }

    private boolean isValid(int i, int j, boolean[][] vis, int[][] arr){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || vis[i][j]==true)
            return false;
        return true;
    }
}