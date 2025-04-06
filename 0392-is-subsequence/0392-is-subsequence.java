class Solution {
    public boolean isSubsequence(String s, String t) {
        int s1 = 0;
        int s2 = 0;
        while(s1 < s.length() && s2 < t.length()){
            if(s.charAt(s1) == t.charAt(s2)){
                s1++;
            }
            s2++;
        }
        return s1 == s.length();
    }
}