class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Integer.MIN_VALUE;
        for(int p : piles){
            r = Math.max(p,r);
        }

        int l = 1;
        int ans = r;

        while(l <= r){
            int mid = l+(r-l)/2;
            if(canEat(piles, mid, h)){
                ans = mid;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return ans;
    }

    private boolean canEat(int[] piles, int mid, int h){
        long sum = 0;
        for(int i=0; i<piles.length; i++){
           sum += piles[i]/mid;
           
           if(piles[i] % mid != 0){
                sum++;
           }
        }

        return sum <= h;
    }

}