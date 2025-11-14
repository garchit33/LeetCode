class Solution {
    class Pair {
        int x;
        int color;
        Pair(int x, int color){
            this.x = x;
            this.color = color;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Pair>> graph = new ArrayList<>();
        int[][] arr = new int[n][2];
        for(int a[] : arr){
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int red[] : redEdges){
            graph.get(red[0]).add(new Pair(red[1],1));
        }

        for(int blue[] : blueEdges){
            graph.get(blue[0]).add(new Pair(blue[1],0));
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,1));
        q.offer(new Pair(0,0));
        arr[0][1] = 0;
        arr[0][0] = 0;
        int path = 0;
        while(q.size() > 0){
            int size = q.size();
            path++;
            for(int i=0; i<size; i++){
                Pair rm = q.poll();
                for(Pair nbr : graph.get(rm.x)){
                    if(nbr.color != rm.color && arr[nbr.x][nbr.color] > path){
                        q.offer(nbr);
                        arr[nbr.x][nbr.color] = path;
                    }
                }
            } 
        }

        int res[] = new int[n];
        for(int i=0; i<arr.length; i++){
            res[i] = Math.min(arr[i][0], arr[i][1]);
            if(res[i] == Integer.MAX_VALUE)
                res[i] = -1;
        }

        return res;
    }
}