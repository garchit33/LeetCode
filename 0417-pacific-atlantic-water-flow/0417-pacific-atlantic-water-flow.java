class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();
        boolean vis1[][] = new boolean[heights.length][heights[0].length];
        boolean vis2[][] = new boolean[heights.length][heights[0].length];

        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                if(i==0 || j==0){
                    pacific.offer(new int[]{i,j});
                    vis1[i][j]=true;
                }
                if(i==heights.length-1 || j==heights[0].length-1){
                    atlantic.offer(new int[]{i,j});
                    vis2[i][j]=true;
                }
            }
        }

        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        traverse(heights, vis1, pacific, dirs);
        // print(vis1);
        traverse(heights, vis2, atlantic, dirs);
        // print(vis2);

        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<vis1.length; i++){
            for(int j=0; j<vis1[0].length; j++){
                if(vis1[i][j] && vis2[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    private void print(boolean vis[][]){
        for(int i=0;i<vis.length;i++){
            for(int j=0;j<vis[0].length;j++){
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void traverse(int[][] heights, boolean[][] vis, Queue<int[]> queue, int[][] dirs){
        while(queue.size()>0) {
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] rm = queue.poll();
                int x = rm[0];
                int y = rm[1];
                for(int[] dir : dirs){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(isValid(heights, nx, ny, x, y, vis)){
                        queue.offer(new int[]{nx,ny});
                        vis[nx][ny] = true;
                    }   
                }
            }
        }
    }

    private boolean isValid(int[][] heights, int nx, int ny, int x, int y, boolean[][] vis){
        if(nx<0 || ny<0 || nx>=heights.length || ny>=heights[0].length || vis[nx][ny] || heights[nx][ny]<heights[x][y])
            return false;
        
        return true;
    }
}