class Solution {
    class Pair {
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        int minReq = 0;
        int[][] dirs = new int[][]{{0,-1}, {0,1}, {1,0},{-1,0}};

        Queue<Pair> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2)
                    queue.offer(new Pair(i,j));
                if(grid[i][j] == 1)
                    freshCount++;
            }
        }
        if(freshCount == 0)
            return 0;

        while(queue.size() > 0){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Pair pair = queue.poll();
                int x = pair.x;
                int y = pair.y;
                for(int[] dir : dirs){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(isValid(grid, nx, ny)){
                        queue.offer(new Pair(nx,ny));
                        grid[nx][ny] = 2;
                        freshCount--;
                    }
                }
            }
            minReq++;
        }
        return freshCount==0?minReq-1:-1;
    }

    private boolean isValid(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 2 || grid[i][j]==0)
            return false;
        
        return true;
    }
}