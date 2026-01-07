class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] freq = new int[n];
        for(int[] arr : requests){
            freq[arr[0]]++;
            if(arr[1]+1 < n)
                freq[arr[1]+1]--;
        }

        for(int i=1; i<n; i++){
            freq[i]+=freq[i-1];
        }

        Arrays.sort(nums);
        Arrays.sort(freq);
        long ans = 0;
        int mod = 1_000_000_007;

        for(int i = n-1; i>=0; i--) {
            ans = (ans + 1L * freq[i] * nums[i]) % mod;
        }

        return (int) ans;
    }
}