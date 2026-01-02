class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int sum = 0;
        for(int i = s.length()-1; i>=0; i--){
           sum = (sum + shifts[i]) % 26;
           shifts[i] = sum;
        }

        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; i++){
            ch[i] = (char) ((ch[i]-'a' + shifts[i]) % 26 + 'a');
        }
        return new String(ch);
    }
}