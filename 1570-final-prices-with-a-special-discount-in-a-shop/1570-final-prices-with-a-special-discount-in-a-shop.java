class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for(int i = prices.length-1; i>=0; i--){
            while(stack.size()>0 && prices[i]<stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(prices[i]);
                continue;
            }
            int x = stack.peek();
            stack.push(prices[i]);
            prices[i] = prices[i]-x;
        }
        return prices;
    }
}