class TimeMap {
    class Pair {
        String value;
        int timestamp;
        
        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }

        public String toString(){
            return value + " " + timestamp;
        }
    }
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(value, timestamp));
        map.put(key, list);
       // printMap(map);
    }

    private void printMap(Map<String, List<Pair>> map){
        for(Map.Entry<String, List<Pair>> m : map.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue().toString());
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";

        List<Pair> list = map.get(key);
        String ans = "";
        int start = 0;
        int end = list.size() - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            Pair p = list.get(mid);
            if(p.timestamp > timestamp){
                end = mid-1;
            }else {
                ans = p.value;
                start = mid+1;
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */