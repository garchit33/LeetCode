class Solution {
    public List<Integer> eventualSafeNodes(int[][] graphs) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<graphs.length; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.size()];
        for(int i=0; i<graphs.length; i++){
            for(int j : graphs[i]){
                graph.get(j).add(i);
            }
            indegree[i] = graphs[i].length;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();
        while(q.size() > 0){
            int rm = q.poll();
            ans.add(rm);
            for(int nbr : graph.get(rm)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}