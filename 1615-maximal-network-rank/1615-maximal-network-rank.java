class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] r : roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }

        int max=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int rank = graph.get(i).size() + graph.get(j).size();
                if(graph.get(i).contains(j))
                    rank--;

                max = Math.max(max, rank);
            }
        }
        return max;
    }
}