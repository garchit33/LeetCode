class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int arr[][] = new int[n][n];

        for(int a[] : arr){
            Arrays.fill(a, n);
        }

        for(int[] m : mines){
            arr[m[0]][m[1]] = 0;
        }

        for(int i=0; i<n; i++){
            for(int j=0, k=n-1, l=0, r=0, u=0, d=0; j<n; j++,k--){
                arr[i][j] = Math.min(arr[i][j], l=arr[i][j] == 0 ? 0 : l+1);
                arr[i][k] = Math.min(arr[i][k], r=arr[i][k] == 0 ? 0 : r+1);
                arr[j][i] = Math.min(arr[j][i], u=arr[j][i] == 0 ? 0 : u+1);
                arr[k][i] = Math.min(arr[k][i], d=arr[k][i] == 0 ? 0 : d+1);
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(ans, arr[i][j]);
            }
        }

        return ans;
    }
}