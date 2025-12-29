class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        boolean[][] isConnected = new boolean[n][n];

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];

            degree[u]++;
            degree[v]++;

            isConnected[u][v] = true;
            isConnected[v][u] = true;
        }

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int rank = degree[i] + degree[j];

                if(isConnected[i][j] && isConnected[j][i])
                    rank--;

                max = Math.max(max, rank);
            }
        }
        return max;
    }
}