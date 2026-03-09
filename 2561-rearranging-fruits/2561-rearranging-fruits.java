class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> totalCounts = new HashMap<>();
        for(int fruit : basket1)
            totalCounts.put(fruit, totalCounts.getOrDefault(fruit,0)+1);
        
        
        for(int fruit : basket2)
            totalCounts.put(fruit, totalCounts.getOrDefault(fruit,0)+1);
        
        int minValue = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry : totalCounts.entrySet()){
            if(entry.getValue() % 2 != 0)
                return -1;
            minValue = Math.min(minValue, entry.getKey());
        }

        HashMap<Integer, Integer> basket1Count = new HashMap<>();
        for(int fruit : basket1)
            basket1Count.put(fruit, basket1Count.getOrDefault(fruit,0)+1);
        
        List<Long> fruitsToSwap = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : totalCounts.entrySet()){
            int fruit = entry.getKey();
            int diff = basket1Count.getOrDefault(fruit, 0) - (entry.getValue()/2);
            for(int i=0; i<Math.abs(diff); i++){
                fruitsToSwap.add((long) fruit);
            }
        }

        Collections.sort(fruitsToSwap);

        int requiredSwaps = fruitsToSwap.size()/2;
        long totalCost = 0;
        for(int i=0; i<requiredSwaps; i++){
            totalCost += Math.min(fruitsToSwap.get(i), 2*minValue);
        }

        return totalCost;
    }
}