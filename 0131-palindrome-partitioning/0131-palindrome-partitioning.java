class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        find(s, 0, new ArrayList<>());
        return ans;
    }

    private void find(String s, int idx, List<String> list){
        if(idx == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int end=idx; end<s.length(); end++){
            if(isPalindrome(s, idx, end)){
                list.add(s.substring(idx,end+1));
                find(s, end+1, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
