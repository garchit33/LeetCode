class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1)
                    peri = dfs(grid, i, j);
            }
        }
        return peri;
    }

    private int dfs(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0)
            return 1;
        if(grid[i][j] == 2)
            return 0;

        grid[i][j] = 2;
        int up = dfs(grid, i-1, j);
        int down = dfs(grid, i+1, j);
        int left = dfs(grid, i, j-1);
        int right = dfs(grid, i, j+1);
        return up+down+left+right;
    }
}