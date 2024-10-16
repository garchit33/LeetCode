class Solution {
    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        // printMatrix(matrix);
        inverseMatrix(matrix);
        // printMatrix(matrix);
    }

    private void transposeMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int  j=0; j<i; j++){
                int val = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = val;
            }
        }
    }

    private void inverseMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            int x = matrix.length-1;
            for(int j=0; j<x; j++){
                int val = matrix[i][j];
                matrix[i][j] = matrix[i][x];
                matrix[i][x--] = val;
            }
        }
    }

    private void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}