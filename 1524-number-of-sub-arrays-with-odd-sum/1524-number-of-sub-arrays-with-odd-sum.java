class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        int oddCount = 0;
        int evenCount = 1;
        int sum = 0;
        int ans = 0;

        for(int a : arr){
            sum+=a;

            if(sum % 2 == 0){
                ans = (ans + oddCount) % mod;
                evenCount++;
            }else {
                ans = (ans + evenCount) % mod;
                oddCount++;
            }
        }
        return ans;
    }
}