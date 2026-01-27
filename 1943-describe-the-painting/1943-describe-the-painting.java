class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        for(int[] seg: segments){
            map.put(seg[0], map.getOrDefault(seg[0], 0L) + seg[2]);
            map.put(seg[1], map.getOrDefault(seg[1], 0L) - seg[2]);
        }

        List<List<Long>> ans = new ArrayList<>();
        long start = 1;
        long sum = 0;
        for(int key : map.keySet()){
            if(sum > 0){
                ans.add(Arrays.asList(start, (long)key, sum));
            }
            sum += map.get(key);
            start = key;
        }
        return ans;
    }
}