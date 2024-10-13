class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0 && n==1){
              return 1;
        }else if(trust.length == 0) {
            return -1;
        }
            
        int[] arr = new int[n+1];
        for(int nums[] : trust){
            arr[nums[0]]--;
            arr[nums[1]]++;
        }

        for(int i=0; i<=n; i++){
            if(arr[i] == n-1)
                return i;
        }
        return -1;
    }
}