class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] prefix = new int[mat.length+1][mat[0].length+1];

        for(int i=1; i<=mat.length; i++){
            for(int j=1; j<=mat[0].length; j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + mat[i-1][j-1];
            }
        }

        int ans = 0;
        int start = 0;
        int end = Math.min(mat.length, mat[0].length)-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            int minSum = Integer.MAX_VALUE;

            for(int r=1; r+mid <= mat.length; r++){
                for(int c=1; c+mid<=mat[0].length; c++){
                    int sum = prefix[r+mid][c+mid] - prefix[r-1][c+mid] - prefix[r+mid][c-1] + prefix[r-1][c-1];
                    minSum = Math.min(minSum, sum);
                }
            }

            if(minSum <= threshold){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}