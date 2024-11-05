class Solution {
    public String compressedString(String word) {
        int left = 0;
        int right = 0;
        int count = 0;
        StringBuilder comp = new StringBuilder();
        while(right < word.length()){
            while(right < word.length() && word.charAt(left) == word.charAt(right)){
                right++;
                count++;
                if(count == 9)
                    break;
            }
            comp.append(count);
            comp.append(word.charAt(left));

            count = 0;
            left = right;
        }
        return comp.toString();
    }
}