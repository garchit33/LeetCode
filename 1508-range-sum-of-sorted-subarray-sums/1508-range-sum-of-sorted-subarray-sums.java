class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1_000_000_007;
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++){
            arr[i+1] = arr[i] + nums[i];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> a-b);

        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                pq.offer(arr[i]-arr[j]);
            }
        }

        long ans = 0;
        for(int i=1; i<=right; i++){
            int val = pq.poll();
            if(i >= left){
                ans = (ans + val) % mod;
            }
        }
        return (int) ans;
    }
}