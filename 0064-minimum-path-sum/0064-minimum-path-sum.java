class Solution {
    public int minPathSum(int[][] arr) {
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(i==0 && j==0)
                    continue;
                else if(i == 0){
                    arr[i][j]+=arr[i][j-1];
                }
                else if(j == 0){
                    arr[i][j]+=arr[i-1][j];
                }else {
                    arr[i][j] += Math.min(arr[i-1][j], arr[i][j-1]);
                }
            }
        }

        return arr[arr.length-1][arr[0].length-1];
    }
}