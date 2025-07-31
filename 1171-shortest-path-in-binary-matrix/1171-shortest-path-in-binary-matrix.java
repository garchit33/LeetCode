class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0] == null || grid[0][0] == 1)
            return -1;
        int dirs[][] = new int[][]{{0,-1},{0,1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int count = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});

        while(q.size()>0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] rm = q.poll();
                int x = rm[0];
                int y = rm[1];
                if(x == grid.length-1 && y == grid[0].length-1)
                    return count;
                for(int[] dir : dirs){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(isValid(nx,ny,grid,vis)){
                        vis[nx][ny]=true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid, boolean vis[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 1 || vis[i][j])
            return false;
        
        return true;
    }
}