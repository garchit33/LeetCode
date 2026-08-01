class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        find(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void find(int[] arr, int target, int idx, List<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(target < 0 || idx == arr.length)
            return;

        for(int i=idx; i<arr.length; i++){
            list.add(arr[i]);
            find(arr, target-arr[i], i, list);
            list.remove(list.size()-1);
        }
    }
}