class Solution {
    int[][] dp = new int[20001][4];
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int l=0;
        int r=0;
        int sum=0;
        int[] sumArr = new int[nums.length-k+1];

        while(r < nums.length){
            sum+=nums[r];

            if(r-l+1 == k){
                sumArr[l] = sum;
                sum-=nums[l];
                l++;
            }
            r++;
        }

        for(int arr[] : dp)
            Arrays.fill(arr, -1);

        List<Integer> result = new ArrayList<>();
        solve(sumArr, 0, 3, k, result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void solve(int[] arr, int idx, int count, int k, List<Integer> result){
        if(count==0 || idx >= arr.length)
            return;
        
        int take = arr[idx] + helper(arr, k, idx+k, count-1);
        int notTake = helper(arr, k, idx+1, count);

        if(take >= notTake){
            result.add(idx);
            solve(arr, idx+k, count-1, k, result);
        }else {
           solve(arr, idx+1, count, k, result);
        }
    }

    private int helper(int[] arr, int k, int idx, int count){
        if(count==0)
            return 0;

        if(idx >= arr.length)
            return Integer.MIN_VALUE;

        if(dp[idx][count] != -1)
            return dp[idx][count];
        
        int take = arr[idx] + helper(arr, k, idx+k, count-1);
        int notTake = helper(arr, k, idx+1, count);

        return dp[idx][count] = Math.max(take, notTake);
    }
}