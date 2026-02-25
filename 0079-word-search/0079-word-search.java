class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int idx){
        if(idx == word.length())
            return true;
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == '#' || board[i][j] != word.charAt(idx))
            return false;
        
        char curValue = board[i][j];
        board[i][j] = '#';
        
        if(backtrack(board, word, i+1, j, idx+1)
        || backtrack(board, word, i-1, j, idx+1)
        || backtrack(board, word, i, j+1, idx+1)
        || backtrack(board, word, i, j-1, idx+1)){
            return true;
        }

        board[i][j] = curValue;
        return false;
    }
}