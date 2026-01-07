class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> ST = new HashMap<>();
        Map<Character, Character> TS = new HashMap<>();


        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(ST.containsKey(c1) && ST.get(c1) != c2){
                return false;
            }

            if(TS.containsKey(c2) && TS.get(c2) != c1){
                return false;
            }

            ST.put(c1, c2);
            TS.put(c2, c1);
        }

        return true;
    }
}