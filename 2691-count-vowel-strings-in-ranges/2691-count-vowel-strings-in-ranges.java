class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] arr = new int[words.length];
        int count = 0;
        for(int i=0; i<words.length; i++){
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))){
                count++;
            }
            arr[i] = count;
        }

        int[] ans = new int[queries.length]; 
        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] = arr[end]-arr[start];
            if(isVowel(words[start].charAt(0)) && isVowel(words[start].charAt(words[start].length()-1)))
                ans[i]++;
        }
        return ans;
    }

    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        return false;
    }

}