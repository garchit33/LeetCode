class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        find(nums, ans, new ArrayList<>(), vis);
        return ans;
    }

    private void find(int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] vis){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1] && !vis[i-1] || vis[i])
                continue;

            list.add(nums[i]);
            vis[i] = true;
            find(nums, ans, list, vis);
            vis[i] = false;
            list.remove(list.size()-1);
        }
    }
}