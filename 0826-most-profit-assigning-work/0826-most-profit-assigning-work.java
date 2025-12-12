class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDifficulty = 0;
        for(int i=0; i<difficulty.length; i++){
            maxDifficulty = Math.max(maxDifficulty, difficulty[i]);
        }

        int[] maxProfitForDifficulty = new int[maxDifficulty + 1];
        for(int i=0; i<difficulty.length; i++){
            maxProfitForDifficulty[difficulty[i]] = Math.max(maxProfitForDifficulty[difficulty[i]], profit[i]);
        }

        for(int i=1; i<=maxDifficulty; i++){
            maxProfitForDifficulty[i] = Math.max(maxProfitForDifficulty[i], maxProfitForDifficulty[i-1]); 
        }

        int ans = 0;
        for(int ability : worker){
            if(ability > maxDifficulty){
                ans += maxProfitForDifficulty[maxDifficulty];
            }else {
                ans += maxProfitForDifficulty[ability];
            }
        }

        return ans;
    }
}