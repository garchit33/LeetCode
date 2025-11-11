class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;
        while(q.size() > 0){
            int rm = q.poll();
            for(int nbr : rooms.get(rm)){
                if(!vis[nbr]){
                    q.offer(nbr);
                    vis[nbr] = true;
                }
            }
        }

        for(int i=0; i<vis.length; i++){
            if(!vis[i])
                return false;
        }

        return true;
    }
}