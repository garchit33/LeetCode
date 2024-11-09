class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] vis = new boolean[candidates.length];
        find(candidates, target, 0, new ArrayList<>(), vis);
        return ans;
    }

    private void find(int[] arr, int target, int pos, List<Integer> list, boolean[] vis){
        if(target<0)
            return;
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(pos == arr.length)
            return;
        
        for(int i=pos; i<arr.length; i++){
            if(i>0 && arr[i] == arr[i-1] && !vis[i-1])
                continue;
            
            list.add(arr[i]);
            vis[i] = true;
            find(arr, target-arr[i], i+1, list, vis);
            vis[i] = false;
            list.remove(list.size()-1);
        }
    }
}