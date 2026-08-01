class Solution {
    class TrieNode {
        TrieNode[] arr = new TrieNode[26];
        boolean isEnd;
        TrieNode() {
            for(int i=0; i<26; i++)
                arr[i] = null;
            isEnd = false;
        }
    }

    private void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.arr[idx] == null)
                curr.arr[idx] = new TrieNode();
            curr = curr.arr[idx];
        }
        curr.isEnd = true;
    }
    
    private boolean dfs(TrieNode root, String word, int idx, Boolean[] dp){
        if(idx == word.length())
            return true;
        
        if(dp[idx] != null)
            return dp[idx];

        TrieNode curr = root;
        for(int i = idx; i < word.length(); i++){
            int c = word.charAt(i)-'a';
            if(curr.arr[c] == null)
                break;
            curr = curr.arr[c];
            if(curr.isEnd){
                if(dfs(root, word, i+1, dp))
                    return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        TrieNode root = new TrieNode();
        
        List<String> ans = new ArrayList<>();

        for(int i=0; i<words.length; i++){

            if(words[i].length() == 0)
                continue;

            Boolean[] dp = new Boolean[words[i].length()];
            if(dfs(root, words[i], 0, dp))
                ans.add(words[i]);
            
            insert(root, words[i]);
        }

        return ans;
    }
}