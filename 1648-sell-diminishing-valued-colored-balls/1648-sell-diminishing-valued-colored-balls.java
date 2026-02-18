class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int mod = (int) 1e9+7;
        int max = 0;
        for(int i : inventory){
            max = Math.max(i, max);
        }

        int start = 0;
        int end = max;
        while(start < end){
            int mid = start + (end-start)/2;

            if(isValid(inventory, orders, mid)){
                end = mid;
            }else {
                start = mid+1;
            }
        }

        long ans = 0;
        for(int x : inventory){
            if(x > start){
                ans+=(long)(x+start+1)*(x-start)/2;
                ans%=mod;
                orders-=(x-start);
            }
        }

        ans += (long) start * orders;
        return (int) (ans % mod);
    }

    private boolean isValid(int[] inventory, int orders, int mid){
        long sum = 0;
        for(int i: inventory){
            sum+=Math.max(i-mid, 0);
        }

        return sum<=orders;
    }
}