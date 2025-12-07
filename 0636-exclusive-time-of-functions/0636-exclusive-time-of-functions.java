class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = -1;
        for(String str : logs){
            String arr[] = str.split(":");
            int id = Integer.parseInt(arr[0]);
            int currTime = Integer.parseInt(arr[2]);
            boolean isStart = arr[1].equals("start")?true:false;

            if(isStart){
                if(!stack.isEmpty()){
                    int topId = stack.peek();
                    ans[topId]+=currTime-prev-1;
                }
                stack.push(id);
            }else {
                int topId = stack.pop();
                ans[topId]+=currTime-prev+1;
            }

            prev = currTime;
        }
        return ans;  
    }
}