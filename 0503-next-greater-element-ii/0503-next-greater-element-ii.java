class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return ans;
    }
}