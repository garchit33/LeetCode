class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l=0;
        int r=0;
        int cost = 0;
        int ans = 0;
        while(r<s.length()){
            cost += Math.abs(s.charAt(r)-t.charAt(r));
            while(l<=r && cost>maxCost){
                cost -= Math.abs(s.charAt(l)-t.charAt(l));
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}