class Solution {
    class TrieNode {
        TrieNode[] arr = new TrieNode[26];
        boolean isEnd;
        TrieNode(){
            for(int i=0; i<26; i++)
                arr[i] = null;
            isEnd = false;
        }
    }

    private void insert(String word, TrieNode root){
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
        for(int i=idx; i<word.length();i++){
            int x = word.charAt(i)-'a';
            if(curr.arr[x] == null)
                break;
            curr = curr.arr[x];
            if(curr.isEnd){
                if(dfs(root, word, i+1, dp))
                    return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();

        for(String str : wordDict){
            insert(str, root);
        }

        Boolean[] dp = new Boolean[s.length()];
        return dfs(root, s, 0, dp);
    }
}