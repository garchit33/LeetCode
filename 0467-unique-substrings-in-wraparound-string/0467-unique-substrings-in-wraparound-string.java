class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];
        dp[s.charAt(0)-'a'] = 1;

        int count = 1;
        for(int i=1; i<s.length(); i++){
            int x = s.charAt(i)-'a';
            int y = s.charAt(i-1)-'a';
            if(x==0 && y==25)
                count++;
            else if(x-y == 1)
                count++;
            else
                count = 1;
            
            dp[x] = Math.max(dp[x], count);
        }

        int sum = 0;
        for(int i=0; i<dp.length; i++){
            sum+=dp[i];
        }

        return sum;
    }
}