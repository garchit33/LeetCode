class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        find(nums, list, 0);
        return ans;
    }

    private void find(int[] nums, List<Integer> list, int idx) {
        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        find(nums, list, idx+1);
        list.remove(list.size()-1);
        find(nums, list, idx+1);
    }
}