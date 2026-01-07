class SummaryRanges {
    TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap<Integer, Integer>();
    }

    public void addNum(int value) {
        Map.Entry<Integer, Integer> floor = map.floorEntry(value);
        Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(value);

        if(floor != null && value >= floor.getKey() && value <= floor.getValue())
            return;

        if((floor == null || value-floor.getValue() > 1) && (ceiling == null || ceiling.getKey()-value > 1)){
            map.put(value,value);
            return;
        }

        if((floor != null && value-floor.getValue() == 1) && (ceiling != null && ceiling.getKey()-value == 1)){
            map.put(floor.getKey(), ceiling.getValue());
            map.remove(ceiling.getKey());
            return;
        }

        if(floor != null && value-floor.getValue() == 1){
            map.put(floor.getKey(),value);
            return;
        }else {
            map.put(value, ceiling.getValue());
            map.remove(ceiling.getKey());
        }
    }

    public int[][] getIntervals() {
        int i=0;
        int ans[][] = new int[map.size()][2];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans[i][0] = entry.getKey();
            ans[i++][1] = entry.getValue();
        }
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */