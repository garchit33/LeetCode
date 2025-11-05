class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int startCol = 0;
        int endCol = mat[0].length-1;

        while(startCol<=endCol){
            int midCol = startCol + (endCol-startCol)/2;
            int maxRow = 0;
            int maxElement = mat[maxRow][midCol];
            for(int row = 0; row<mat.length; row++){
                if(mat[row][midCol] >= maxElement){
                    maxElement = mat[row][midCol];
                    maxRow = row;
                }
            }

            boolean isLeftBig = midCol-1 >= startCol && mat[maxRow][midCol-1] > mat[maxRow][midCol];
            boolean isRightBig = midCol+1 <= endCol && mat[maxRow][midCol+1] > mat[maxRow][midCol];

            if(!isLeftBig && !isRightBig)
                return new int[]{maxRow, midCol};
            
            if(isLeftBig)
                endCol = midCol-1;
            else
                startCol = midCol+1;
        }
        return new int[]{-1,-1};
    }
}