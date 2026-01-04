class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        long[] arr = new long[n];
        Arrays.fill(arr, Long.MAX_VALUE);
        arr[0] = 0;
        for(int[] res : restrictions){
            int idx = res[0];
            int maxVal = res[1];
            arr[idx] = Math.min(arr[idx], (long) maxVal);
        }

        for(int i=1; i<n; i++){
            arr[i] = Math.min(arr[i], arr[i-1]+diff[i-1]);
        }

        for(int i = n-2; i>=0; i--){
            arr[i] = Math.min(arr[i], arr[i+1]+diff[i]);
        }

        long max = 0;
        for(long a : arr){
            max = Math.max(max, a);
        }

        return (int) max;
    }
}