class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dirs = new int[7][][];

        dirs[1] = new int[][]{{0,-1},{0,1}};
        dirs[2] = new int[][]{{-1,0},{1,0}};
        dirs[3] = new int[][]{{0,-1},{1,0}};
        dirs[4] = new int[][]{{0,1},{1,0}};
        dirs[5] = new int[][]{{0,-1},{-1,0}};
        dirs[6] = new int[][]{{0,1},{-1,0}};

        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while(q.size()>0){
            int[] rm = q.poll();
            int x = rm[0];
            int y = rm[1];

            if(x == m-1 && y == n-1)
                return true;
            
            for(int[] dir : dirs[grid[x][y]]){
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx>=m || ny>=n || vis[nx][ny])
                    continue;
                
                for(int[] reverse : dirs[grid[nx][ny]]){
                    if(nx + reverse[0] == x && ny + reverse[1] == y){
                        q.offer(new int[]{nx,ny});
                        vis[nx][ny] = true;
                    }
                }
            }
        }
        return false;
    }
}