class Solution {
    int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public int maximumMinutes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] fire = new int[m][n];
        bfsFire(grid, fire);
        if(!bfsPerson(fire,0))
            return -1;
        
        int l=0;
        int r=1000000000;
        int ans=-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(bfsPerson(fire,mid)){
                ans = mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }

    private boolean bfsPerson(int[][] fire, int time){
        if(fire[0][0] <= time)
            return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[fire.length][fire[0].length];
        q.offer(new int[]{0,0});

        while(q.size()>0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] rm = q.poll();
                int x = rm[0];
                int y = rm[1];
                int arrivalTime = time+1;

                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(!isValid(fire, nx, ny))
                        continue;

                    if(nx == fire.length-1 && ny == fire[0].length-1){
                        if(fire[nx][ny] < arrivalTime)
                            continue;
                        return true;
                    }

                    if(vis[nx][ny] || fire[nx][ny] <= arrivalTime)
                        continue;
                    
                    if(fire[nx][ny] > arrivalTime){
                        vis[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            time++;
        }
        return false;
    }

    private void bfsFire(int[][] grid, int[][] fire){
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    fire[i][j] = -1;
                }else if(grid[i][j] == 1){
                    fire[i][j] = 0;
                    q.offer(new int[]{i,j});
                }else {
                    fire[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int time = 1;
        while(q.size() > 0){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] rm = q.poll();
                int x = rm[0];
                int y = rm[1];
                
                for(int[] dir : dirs){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(!isValid(fire, nx,ny))
                        continue;

                    if(fire[nx][ny] > time){
                        fire[nx][ny] = time;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            time++;
        }
    }

    private boolean isValid(int[][] arr, int i, int j){
        if(i<0 || i>=arr.length || j<0 || j>=arr[0].length || arr[i][j] == -1)
            return false;
        
        return true;
    }
}