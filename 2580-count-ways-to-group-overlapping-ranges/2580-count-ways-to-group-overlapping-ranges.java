class Solution {
    public int countWays(int[][] ranges) {
        int mod = 1_000_000_007;
        int res = 1;
        int last = -1;
        Arrays.sort(ranges, (a,b) -> a[0]-b[0]);
        for(int[] r : ranges){
            if(last < r[0]){
                res = res * 2 % mod;
            }
            last = Math.max(last, r[1]);
        }
        return res;
    }
}