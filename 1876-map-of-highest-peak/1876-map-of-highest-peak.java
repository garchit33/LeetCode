class Solution {
    public int[][] highestPeak(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxVal = 2000;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 1) matrix[r][c] = 0;
                else matrix[r][c] = 1;
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] != 0) {
                    int top = maxVal;
                    int left = maxVal;
                    if (r - 1 >= 0) top = matrix[r - 1][c];
                    if (c - 1 >= 0) left = matrix[r][c - 1];
                    matrix[r][c] = Math.min(top, left) + 1;
                }
            }
        }
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (matrix[r][c] != 0) {
                    int bottom = maxVal;
                    int right = maxVal;
                    if (r + 1 < m) bottom = matrix[r + 1][c];
                    if (c + 1 < n) right = matrix[r][c + 1];
                    matrix[r][c] = Math.min(matrix[r][c], Math.min(bottom, right) + 1);
                }
            }
        }
        return matrix;
    }
    // public int[][] highestPeak(int[][] isWater) {
    //     int m = isWater.length;
    //     int n = isWater[0].length;
    //     Queue<int[]> q = new LinkedList<>();
    //     boolean vis[][] = new boolean[m][n];
    //     for(int i=0; i<m; i++){
    //         for(int j=0; j<n; j++){
    //             if(isWater[i][j]==1){
    //                 q.offer(new int[]{i,j});
    //                 vis[i][j] = true;
    //                 isWater[i][j] = 0;
    //             }
    //         }
    //     }

    //     int count = 1;
    //     int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    //     while(q.size()>0){
    //         int size = q.size();
    //         for(int i=0; i<size; i++){
    //             int[] rm = q.poll();
    //             int x = rm[0];
    //             int y = rm[1];
    //             for(int[] dir : dirs){
    //                 int nx = x+dir[0];
    //                 int ny = y+dir[1];
    //                 if(isValid(nx,ny,vis,isWater)){
    //                     q.offer(new int[]{nx,ny});
    //                     vis[nx][ny]=true;
    //                     isWater[nx][ny]=count;
    //                 }
    //             }
    //         }
    //         count++;
    //     }
    //     return isWater;
    // }

    // private boolean isValid(int i, int j, boolean[][] vis, int[][] arr){
    //     if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || vis[i][j] == true)
    //         return false;
    //     return true;
    // }
}