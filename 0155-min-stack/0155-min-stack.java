class MinStack {
    List<int[]> list;
    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int value) {
       int[] top = list.isEmpty() ? new int[]{value, value} : list.get(list.size()-1);
       int minValue = top[1];
       if(minValue > value){
            minValue = value;
       }
       list.add(new int[]{value, minValue});
    }
    
    public void pop() {
        if(!list.isEmpty())
            list.remove(list.size()-1);
    }
    
    public int top() {
        return list.isEmpty() ? -1 : list.get(list.size()-1)[0];
    }
    
    public int getMin() {
        return list.isEmpty() ? -1  : list.get(list.size()-1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */