class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int countRequired = t.length();
        int l=0;
        int r=0;
        int windowSize = Integer.MAX_VALUE;
        int startIndex = 0;
        while(r<s.length()){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) > 0){
                countRequired--;
            }
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)-1);

            while(countRequired == 0){
                if(windowSize > (r-l+1)){
                    windowSize = r-l+1;
                    startIndex = l;
                }

                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)+1);
                if(map.get(s.charAt(l)) > 0){
                    countRequired++;
                }
                l++;
            }
            r++;
        }

        return windowSize == Integer.MAX_VALUE ? "" : s.substring(startIndex,  startIndex + windowSize);
    }
}