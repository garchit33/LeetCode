class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] ch : board)
            Arrays.fill(ch,'.');
        
        generate(board, 0);
        return res;
    }

    private void generate(char[][] board, int row){
        if(row == board.length){
            List<String> list = new ArrayList<>();
            for(int i=0; i<board.length; i++){
                list.add(new String(board[i]));
            }
            res.add(list);
        }

        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                generate(board, row+1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col){
        //Check top rows
        for(int i=0; i<row; i++){
            if(board[i][col] == 'Q')
                return false;
        }

        //Check left Diagonal
        int maxLeft = Math.min(row,col);
        for(int i=1; i<=maxLeft; i++){
            if(board[row-i][col-i] == 'Q')
                return false;
        }

        //Check right Diagonal
        int maxRight = Math.min(row, board.length-1-col);
        for(int i=1; i<=maxRight; i++){
            if(board[row-i][col+i] == 'Q')
                return false;
        }
        return true;
    }


}