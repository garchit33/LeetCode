class Solution {
    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        inverseMatrix(matrix);
    }

    private void transposeMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void inverseMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            int x = matrix.length-1;
            for(int j=0; j<x; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][x];
                matrix[i][x--] = temp;
            }
        }
    }
}