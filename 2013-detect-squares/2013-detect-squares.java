class DetectSquares {
    List<int[]> list;
    HashMap<String, Integer> countMap;

    public DetectSquares() {
        list = new ArrayList<>();
        countMap = new HashMap<>();
    }
    
    public void add(int[] point) {
        String s = point[0] + "," + point[1];
        if(countMap.containsKey(s)){
            countMap.put(s, countMap.get(s)+1);
        }else {
            countMap.put(s, 1);
            list.add(point);
        }
    }
    
    public int count(int[] point) {
        int currX = point[0];
        int currY = point[1];
        int ans = 0;
        for(int[] p : list){
            if(currX != p[0] && currY != p[1] && Math.abs(currX - p[0]) == Math.abs(currY - p[1])){
                String newPoint1 = currX + "," + p[1];
                String newPoint2 = p[0] + "," + currY;
                ans += countMap.getOrDefault(newPoint1, 0) * countMap.getOrDefault(newPoint2, 0) * countMap.get(p[0] + "," + p[1]);
            }
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */