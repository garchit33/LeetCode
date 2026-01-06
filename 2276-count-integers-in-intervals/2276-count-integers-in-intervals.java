class CountIntervals {
    TreeMap<Integer, Integer> map;
    int totalCount = 0;
    public CountIntervals() {
        map = new TreeMap<>();
        totalCount = 0;
    }
    
    public void add(int left, int right) {
        Map.Entry<Integer, Integer> entry = map.floorEntry(right);
        while(entry != null && entry.getValue() >= left){
            int existingLeft = entry.getKey();
            int existingRight = entry.getValue();
            totalCount = totalCount - (existingRight - existingLeft +1);
            left = Math.min(existingLeft, left);
            right = Math.max(existingRight, right);

            map.remove(existingLeft);
            entry = map.floorEntry(right);
        }

        map.put(left, right);
        totalCount+= right-left+1;
    }
    
    public int count() {
        return totalCount;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */