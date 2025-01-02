class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] arr = new int[words.length];
        for(int i=0; i<words.length; i++){
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))){
                arr[i]++;
            }
        }

        int[] ans = new int[queries.length]; 
        int count = 0;
        for(int[] q : queries){
            int start = q[0];
            int end = q[1];
            int sum = 0;
            for(int i=start; i<=end; i++){
                sum = sum + arr[i];
            }
            ans[count] = sum;
            count++;
        }
        return ans;
    }

    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        return false;
    }

}