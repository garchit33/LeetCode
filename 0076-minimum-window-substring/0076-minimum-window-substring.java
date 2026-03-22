class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }

        int countReq = t.length();
        int l=0;
        int r=0;
        int winSize = Integer.MAX_VALUE;
        int startIdx = 0;

        while(r < s.length()){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) > 0){
                countReq--;
            }

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)-1);

            while(countReq == 0){
                if(winSize > (r-l+1)){
                    winSize = r-l+1;
                    startIdx = l;
                }

                map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0)+1);
                if(map.get(s.charAt(l)) > 0){
                    countReq++;
                }
                l++;
            }
            r++;
        }

        return winSize == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx+winSize);
    }
}