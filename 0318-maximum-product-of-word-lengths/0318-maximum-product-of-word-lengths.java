class Solution {
    public int maxProduct(String[] words) {
        int[] bitmask = new int[words.length];

        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                bitmask[i] = bitmask[i] | (1 << (words[i].charAt(j) - 'a'));
            }
        }

        int result = 0;
        for(int i=0; i<bitmask.length; i++){
            for(int j=i; j<bitmask.length; j++){
                if((bitmask[i] & bitmask[j]) == 0){
                    result = Math.max(words[i].length() * words[j].length(), result);
                }
            }
        }

        return result;
    }
}