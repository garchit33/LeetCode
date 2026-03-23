class Solution {
    public int longestIdealString(String s, int k) {
        int ans = 0;
        int arr[] = new int[150];
        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i);
            for(int j=c-k; j<=c+k; j++){
                arr[c] = Math.max(arr[c], arr[j]);
            }
            ans = Math.max(ans, ++arr[c]);
        }
        return ans;
    }
}