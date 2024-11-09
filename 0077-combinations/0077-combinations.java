class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        find(n, k, 1, new ArrayList<>());
        return ans;
    }

    private void find(int n, int k, int pos, List<Integer> list){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(pos > n)
            return;
        
        find(n,k,pos+1,list);
        list.add(pos);
        find(n,k,pos+1,list);
        list.remove(list.size()-1);
    }
}