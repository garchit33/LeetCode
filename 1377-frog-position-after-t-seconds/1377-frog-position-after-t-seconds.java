class Solution {
    class Pair {
        int pos;
        double prob;
        Pair(int pos, double prob){
            this.pos = pos;
            this.prob = prob;
        }
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Pair> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];
        q.offer(new Pair(1, 1.0));
        vis[1] = true;

        int time = 0;

        while(q.size() > 0 && time <= t){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair rm = q.poll();
                int pos = rm.pos;
                double prob = rm.prob;

                int children = 0;
                for(int nbr : graph.get(pos)){
                    if(!vis[nbr])
                        children++;
                }

                if(pos == target){
                    if(children == 0 || time == t)
                        return prob;
                    return 0.0;
                }

                if(children == 0)
                    continue;
                
                double newProb = prob / children;
                for(int nbr : graph.get(pos)){
                    if(!vis[nbr]){
                        vis[nbr] = true;
                        q.offer(new Pair(nbr, newProb));
                    }
                }
            }
            time++;
        }

        return 0.0;
    }
}