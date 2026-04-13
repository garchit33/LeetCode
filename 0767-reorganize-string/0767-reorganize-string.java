class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int maxFreq = 0;
        char maxChar = s.charAt(0);
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
            if(freq[ch-'a'] > maxFreq) {
                maxFreq = freq[ch-'a'];
                maxChar = ch;
            }
        }

        if(maxFreq > (s.length()+1)/2)
            return "";

        char[] result = new char[s.length()];
        int ptr = 0;
        for(int i=0; i<maxFreq; i++){
            result[ptr] = maxChar;
            ptr+=2;
        }
        freq[maxChar-'a'] = 0;

        for(int i=0; i<26; i++){
            if(freq[i] == 0)
                continue;

            for(int j=0; j<freq[i]; j++){
                if(ptr >= s.length())
                    ptr = 1;
                
                result[ptr] = (char)('a'+i);
                ptr+=2;
            }
            freq[i] = 0;
        }

        return String.valueOf(result);
    }
}