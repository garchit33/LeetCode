class Solution {
    public int[] finalPrices(int[] prices) {
        int[] arr = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            boolean flag = false;
            int x=i+1;
            while(x<prices.length){
                if(x<prices.length && prices[x] <= prices[i]){
                    arr[i] = prices[i]-prices[x];
                    flag = true;
                    break;
                }
                x++;
            }
            if(!flag)
                arr[i] = prices[i];
        }
        return arr;
    }
}