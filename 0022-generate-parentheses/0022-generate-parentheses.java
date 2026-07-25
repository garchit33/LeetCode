class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        find(n, 0,0,"");
        return ans;
    }

    private void find(int n, int start, int end, String str) {
        if(start == end && start == n)
            ans.add(str);
        
        if(start > n)
            return;
        
        find(n, start+1, end, str + "(");
        if(start > end){
            find(n, start, end+1, str + ")");
        }
    }
}