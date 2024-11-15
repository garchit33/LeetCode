class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l=0;
        int r=Integer.MAX_VALUE;
        for(int quantity :  quantities)
        {
            r = Math.max(quantity,r);
        }
        int ans=0;

        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(isPossible(mid,quantities,n))
            {
                
                ans = mid;
                r=mid-1;
              //  System.out.println(ans+" "+l);

            }
            else
            l=mid+1;
        }
        return ans;
        
    }

    private boolean isPossible(int cnt, int arr[], int target){
        int total =0;
        if(cnt==0)
        return false;
        for(int i=0;i<arr.length;i++)
        {
            int element = arr[i];
            total+= element%cnt==0?element/cnt:(element/cnt)+1;

            
        }
        return total<=target;
    }
}