class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int prevTime = -1;
        for(String str : logs){
            String[] arr = str.split(":");
            int functionId = Integer.parseInt(arr[0]);
            int time = Integer.parseInt(arr[2]);
            boolean isStart = arr[1].equals("start") ? true : false;

            if(isStart){
                if(stack.size() > 0){
                    int id = stack.peek();
                    ans[id] += time-prevTime-1;
                }
                stack.push(functionId);
            }else {
                int id = stack.pop();
                ans[id] += time-prevTime+1;
            }
            prevTime = time;
        }
        return ans;
    }
}