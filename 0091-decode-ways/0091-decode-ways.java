class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return find(s, 0, dp);
    }

    private int find(String s, int pos, int[] dp){
        if(pos == s.length())
            return 1;
        
        if(s.charAt(pos) == '0')
            return 0;
        
        if(dp[pos] != -1)
            return dp[pos];
        
        int cnt1 = find(s, pos+1, dp);
        int cnt2 = 0;

        if(pos+1 < s.length()){
            int num = Integer.parseInt(s.substring(pos, pos+2));

            if(num >= 10 && num <= 26){
                cnt2 = find(s, pos+2, dp);
            }
        }
        return dp[pos] = cnt1+cnt2;
    } 
}