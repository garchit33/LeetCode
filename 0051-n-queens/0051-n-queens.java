class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = '.';
            }
        }

        checkBoard(board, 0);
        return result;
    }

    private void checkBoard(char[][] board, int row){
        if(row == board.length){
            List<String> list = new ArrayList<>();
            for(int i=0; i<board.length; i++){
                list.add(new String(board[i]));
            }
            result.add(list);
        }

        for(int col=0; col<board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                checkBoard(board, row+1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col){
        for(int i=0; i<row; i++){
            if(board[i][col] == 'Q')
                return false;
        }

        int maxLeft = Math.min(row, col);
        for(int i=0; i<=maxLeft; i++){
            if(board[row-i][col-i] == 'Q')
                return false;
        }

        int maxRight = Math.min(row, board.length-1-col);
        for(int i=0; i<=maxRight; i++){
            if(board[row-i][col+i] == 'Q')
                return false;
        }

        return true;
    }
}