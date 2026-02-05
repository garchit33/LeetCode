class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] arr : dislikes){
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        int[] color = new int[n+1];
        Arrays.fill(color, -1);

        for(int i=1; i<=n; i++){
            if(color[i] == -1){
                if(!bfs(graph, color, i))
                    return false;
            }   
        }
        return true;
    }

    private boolean bfs(List<List<Integer>> graph, int[] color, int src){
        Queue<Integer> q = new LinkedList<>();
        color[src]=0;
        q.offer(src);
        while(q.size()>0){
            int rm = q.poll();
            for(int nbr : graph.get(rm)){
                if(color[nbr] == -1){
                    color[nbr]=1-color[rm];
                    q.offer(nbr);
                }else if(color[nbr] == color[rm]){
                    return false;
                }
            }
        }
        return true;
    }
}