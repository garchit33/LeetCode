class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int x=0,sum=0,count=0;
        for(int i=1;i<=n;i++){
            boolean flag = false;
            while(x<banned.length && banned[x]==i){
                x++;
                flag=true;
            }
            if(flag)
                continue;
            sum+=i;
            if(sum>maxSum)
                return count;
            
            count++;
        }
        return count;
    }
}