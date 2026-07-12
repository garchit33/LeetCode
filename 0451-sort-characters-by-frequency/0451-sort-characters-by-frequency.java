class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(freqMap.entrySet());

        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            Map.Entry<Character, Integer> m = pq.poll();
            int count = m.getValue();
            while(count > 0){
                sb.append(m.getKey());
                count--;
            }
        }

        return sb.toString();
    }
}