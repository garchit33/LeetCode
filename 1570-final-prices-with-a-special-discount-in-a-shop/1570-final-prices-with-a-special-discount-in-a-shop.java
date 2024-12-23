class Solution {
    public int[] finalPrices(int[] prices) {
        for(int i=0; i<prices.length; i++){
            int x=i+1;
            while(x<prices.length){
                if(x<prices.length && prices[x] <= prices[i]){
                    prices[i] = prices[i]-prices[x];
                    break;
                }
                x++;
            }
        }
        return prices;
    }
}