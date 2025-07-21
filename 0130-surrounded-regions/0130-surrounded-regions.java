class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(i == 0 || j == 0 || i==board.length-1 || j==board[0].length-1){
                    if(board[i][j] == 'O')
                        q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(q.size() > 0){
            int[] rm  = q.poll();
            int x = rm[0];
            int y = rm[1];
            board[x][y]='y';
            for(int[] dir : dirs){
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(checkValid(board, nx, ny)){
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'y'){
                    board[i][j] = 'O';
                }else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean checkValid(char[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == 'X' || board[i][j] == 'y')
            return false;

        return true;
    }
}