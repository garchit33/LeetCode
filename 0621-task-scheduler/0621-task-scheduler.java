class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch - 'A']++;
        }

        Arrays.sort(freq);
        int maxIdlePerTask = freq[25]-1;
        int maxIdle = maxIdlePerTask * n;

        for(int i=24; i>=0; i--){
            maxIdle -= Math.min(maxIdlePerTask, freq[i]);
        }

        return maxIdle < 0 ? tasks.length : tasks.length+maxIdle;
    }
}