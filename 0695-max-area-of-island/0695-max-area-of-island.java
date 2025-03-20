class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    int size = dfs(grid,i,j);
                    max = Math.max(max,size);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
            return 0;
            
        grid[i][j]=0;
        int left = dfs(grid,i-1,j);
        int right = dfs(grid,i+1,j);
        int up = dfs(grid, i, j+1);
        int down = dfs(grid, i,j-1);
        return up+down+left+right+1;
    }
}