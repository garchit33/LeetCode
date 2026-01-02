class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[] arr = new int[s.length()+1];
        for(int i=0; i<s.length(); i++){
            int mask = 1 << s.charAt(i) - 'a';
            arr[i+1] = arr[i] ^ mask;
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] q : queries){
            int left = q[0];
            int right = q[1];
            int k = q[2];
            int mask = arr[left] ^ arr[right+1];
            int bitCount = Integer.bitCount(mask);
            ans.add(bitCount/2 <= k);
        }
        return ans;
    }
}