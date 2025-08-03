class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(pq.size()>0){
            Map.Entry<Character, Integer> m = pq.poll();
            int c = m.getValue();
            while(c > 0){
                sb.append(m.getKey());
                c--;
            }
         }

         return sb.toString();
    }
}