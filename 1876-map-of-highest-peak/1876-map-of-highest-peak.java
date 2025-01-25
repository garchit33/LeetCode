class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isWater[i][j]==1){
                    q.offer(new int[]{i,j});
                    vis[i][j] = true;
                    isWater[i][j] = 0;
                }
            }
        }

        int count = 1;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(q.size()>0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] rm = q.poll();
                int x = rm[0];
                int y = rm[1];
                for(int[] dir : dirs){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(isValid(nx,ny,vis,isWater)){
                        q.offer(new int[]{nx,ny});
                        vis[nx][ny]=true;
                        isWater[nx][ny]=count;
                    }
                }
            }
            count++;
        }
        return isWater;
    }

    private boolean isValid(int i, int j, boolean[][] vis, int[][] arr){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || vis[i][j] == true)
            return false;
        return true;
    }
}