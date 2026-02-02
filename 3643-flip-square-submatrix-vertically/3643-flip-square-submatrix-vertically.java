class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int i=0; i<k/2; i++){
            for(int j=0; j<k; j++){
                int temp = grid[i+x][j+y];
                grid[i+x][j+y] = grid[x+k-1-i][j+y];
                grid[x+k-1-i][j+y] = temp;
            }
        }
        return grid;
    }
}