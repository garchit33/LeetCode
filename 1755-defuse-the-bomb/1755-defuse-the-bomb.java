class Solution {
    public int[] decrypt(int[] code, int k) {
        int ans[] = new int[code.length];
        int n=code.length;
        int start =0;
        int end=0;
        int sum=0;
        if(k>0)
        {
            start=1;
            end = k;
        }
        else{
            start = n-Math.abs(k);
            end = n-1;
        }
        for(int i=start;i<=end;i++){
            sum+=code[i];
        }

        for(int i=0;i<n;i++){
            ans[i]=sum;
            sum=sum-code[(start)%n];
            sum=sum+code[(end+1)%n];
            start++;
            end++;
        }
        return ans;
        
    }
}