class Solution {
    class Pair {
        int x;
        double prob;
        Pair(int x, double prob){
            this.x = x;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double arr[] = new double[n];
        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        int x = 0;
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(new Pair(v, succProb[x]));
            graph.get(v).add(new Pair(u, succProb[x++]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.prob,a.prob));
        pq.offer(new Pair(start_node, 1.0));
        arr[start_node] = 1.0;
        while(pq.size() > 0){
            Pair rm = pq.poll();
            if(rm.x == end_node)
                return rm.prob;
            for(Pair nbr : graph.get(rm.x)){
                if(arr[nbr.x] < rm.prob * nbr.prob){
                    arr[nbr.x] = rm.prob * nbr.prob;
                    pq.offer(new Pair(nbr.x, arr[nbr.x]));
                }
            }
        }
        return 0.00;
    }
}