class StockSpanner {
    int idx = 0;
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }
    
    public int next(int price) {    
        while(stack.peek()[1] <= price) {
            stack.pop();
        }
        int diff = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        idx++;

        return diff;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */