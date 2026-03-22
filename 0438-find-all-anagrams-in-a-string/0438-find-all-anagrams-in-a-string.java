class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) { 
            return new ArrayList<>();
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();

        for(int i=0; i<p.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i),0)+1);
        }

        List<Integer> list = new ArrayList<>();
        int l=0;
        int r=p.length();

        if(sMap.equals(pMap))
            list.add(l);

        while(r < s.length()){
            sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r),0)+1);
            sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l),0)-1);

            if(sMap.get(s.charAt(l)) == 0)
                sMap.remove(s.charAt(l));

            l++;
            r++;

            if(sMap.equals(pMap))
                list.add(l);
        }

        return list;
    }
}