class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] arr = new int[startTime.length][3];

        for(int i=0; i<startTime.length; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        int[] dp = new int[startTime.length];
        Arrays.fill(dp, -1);
        return find(arr, 0, startTime.length, dp);
    }

    private int find(int[][] arr, int pos, int n, int[] dp){
        if(pos >= n)
            return 0;

        if(dp[pos] != -1)
            return dp[pos];
        
        int newPos = getNewPos(arr, pos, n);

        int take = arr[pos][2] + find(arr, newPos, n, dp);
        int notTake = find(arr, pos+1, n, dp);
        return dp[pos] = Math.max(take, notTake);
    }

    private int getNewPos(int[][] arr, int pos, int n){
        int l = pos+1;
        int r = n-1;
        int res = n;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid][0] >= arr[pos][1]){
                res = mid;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return res;
    }
}