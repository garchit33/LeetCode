class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for(int item : gain){
            sum+=item;
            max = Math.max(sum,max);
        }
        return max;
    }
}