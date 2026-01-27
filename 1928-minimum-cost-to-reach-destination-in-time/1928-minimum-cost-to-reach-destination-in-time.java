class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int[] minTime = new int[passingFees.length];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<passingFees.length; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.offer(new int[]{0, 0, passingFees[0]});
        minTime[0] = 0;

        while(pq.size() > 0){
            int[] rm = pq.poll();
            int city = rm[0];
            int time = rm[1];
            int cost = rm[2];

            if(city == passingFees.length-1)
                return cost;

            for(int[] nbr : graph.get(city)){
                int newCity = nbr[0];
                int newTime = time + nbr[1];
                int newCost = cost + passingFees[newCity];
                
                if(newTime <= maxTime && newTime < minTime[newCity]){
                    pq.offer(new int[]{newCity, newTime, newCost});
                    minTime[newCity] = newTime;
                }
            }
        }
        return -1;
    }
}