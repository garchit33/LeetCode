class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] prefixSum = new int[mat.length+1][mat[0].length+1];

        for(int i=1; i<=mat.length; i++){
            for(int j=1; j<=mat[0].length; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + mat[i-1][j-1];
            }
        }

        int[][] ans = new int[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                int r1 = Math.max(0, i-k);
                int c1 = Math.max(0, j-k);
                int r2 = Math.min(i+k, mat.length-1);
                int c2 = Math.min(j+k, mat[0].length-1);

                ans[i][j] = prefixSum[r2+1][c2+1] - prefixSum[r2+1][c1] - prefixSum[r1][c2+1] + prefixSum[r1][c1];
            }
        }
        return ans;
    }
}