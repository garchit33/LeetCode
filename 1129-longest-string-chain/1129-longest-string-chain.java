class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        int[] dp = new int[words.length];
        int ans = 0;
        for(int i=0; i<words.length; i++){
            int count = 0;
            for(int j=0; j<i; j++){
                if(compare(words[i], words[j])){
                    count = Math.max(count, dp[j]);
                }
            }
            dp[i] = count+1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private boolean compare(String s, String s1){
        if(s.length() != s1.length()+1)
            return false;
        
        int i=0, j=0;
        while(i < s.length()){
            if(j < s1.length() && s.charAt(i) == s1.charAt(j)){
                i++;
                j++;
            }else {
                i++;
            }
        }

        return i == s.length() && j == s1.length();
    }
}