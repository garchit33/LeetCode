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

    private void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(curr.arr[idx] == null)
                curr.arr[idx] = new TrieNode();
            curr = curr.arr[idx];
        }
        curr.isEnd = true;
    }

    private boolean find(TrieNode root, String word, int idx, Boolean[] dp){
        if(idx == word.length())
            return true;
        
        if(dp[idx] != null)
            return dp[idx];
        
        TrieNode curr = root;
        for(int i=idx; i<word.length(); i++){
            int x = word.charAt(i) - 'a';
            if(curr.arr[x] == null)
                break;
            curr = curr.arr[x];
            if(curr.isEnd){
                if(find(root, word, i+1, dp)){
                    return dp[idx] = true;
                }
            }
        }
        return dp[idx] = false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();

        TrieNode root = new TrieNode();

        for(int i=0; i<words.length; i++){
            if(words[i].length() == 0)
                continue;
            
            Boolean[] dp = new Boolean[words[i].length()];
            if(find(root, words[i], 0, dp))
                ans.add(words[i]);
            
            insert(root, words[i]);
        }
        return ans;
    }
}