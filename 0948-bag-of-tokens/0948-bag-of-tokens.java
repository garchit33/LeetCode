class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int i = 0;
        int j = tokens.length-1;
        int ans = 0;
        while(i<=j){
            if(tokens[i] <= power){
                power -= tokens[i++];
                score++;
                ans = Math.max(ans, score);
            }else if(score > 0){
                score--;
                power += tokens[j--];
            }else{
                break;
            }
        }
        return ans;
    }
}