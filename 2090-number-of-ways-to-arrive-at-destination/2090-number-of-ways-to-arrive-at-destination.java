class Solution {
    class Pair{
        int x;
        long time; 
        Pair(int x, long time){
            this.x = x;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod = 1_000_000_007;
        long time[] = new long[n];
        long ways[] = new long[n];

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int road[] : roads){
            int u = road[0];
            int v = road[1];
            int t = road[2];
            graph.get(u).add(new Pair(v,t));
            graph.get(v).add(new Pair(u,t));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.time,b.time));
        pq.offer(new Pair(0,0));
        ways[0] = 1;
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;
        while(pq.size()>0){
            Pair rm = pq.poll();
            for(Pair nbr : graph.get(rm.x)){
                if(time[nbr.x] > rm.time + nbr.time){
                    time[nbr.x] = rm.time + nbr.time;
                    pq.offer(new Pair(nbr.x, time[nbr.x]));
                    ways[nbr.x] = ways[rm.x];
                }else if(time[nbr.x] == rm.time + nbr.time) {
                    ways[nbr.x] = (ways[nbr.x] + ways[rm.x])% mod;
                }
            }
        }
        return (int) ways[n-1];
    }
}