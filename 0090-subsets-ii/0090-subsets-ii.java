class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        find(list, nums, 0);
        return ans;
    }

    private void find(List<Integer> list, int[] nums, int idx){
        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        find(list, nums, idx+1);
        list.remove(list.size()-1);
        int x = idx+1;
        while(x < nums.length && nums[x] == nums[idx]){
            x++;
        }
        find(list, nums, x);
    }
}