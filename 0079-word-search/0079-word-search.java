class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && backtrack(board, word, vis, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] vis, int i, int j, int idx){
        if(idx == word.length())
            return true;
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || vis[i][j] || board[i][j] != word.charAt(idx))
            return false;
        
        vis[i][j] = true;
        
        if(backtrack(board, word, vis, i+1, j, idx+1)
        || backtrack(board, word, vis, i-1, j, idx+1)
        || backtrack(board, word, vis, i, j+1, idx+1)
        || backtrack(board, word, vis, i, j-1, idx+1)){
            return true;
        }

        vis[i][j] = false;
        return false;
    }
}