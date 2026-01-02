class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> vowelMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        int mask = 0;
        map.put(mask, -1);
        int ans = 0;

        vowelMap.put('a', 0);
        vowelMap.put('e', 1);
        vowelMap.put('i', 2);
        vowelMap.put('o', 3);
        vowelMap.put('u', 4);

        for(int i=0; i<s.length(); i++){
            if(isVowel(s.charAt(i))){
                mask = mask ^ (1 << vowelMap.get(s.charAt(i)));
            }

            if(map.containsKey(mask)){
                ans = Math.max(ans, i-map.get(mask));
            }else {
                map.put(mask, i);
            }
        }
        return ans;
    }

    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        
        return false;
    }
}