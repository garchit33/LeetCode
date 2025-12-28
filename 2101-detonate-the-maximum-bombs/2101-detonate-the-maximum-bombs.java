class Solution {
    public int maximumDetonation(int[][] bombs) {
        int max = 0;

        for(int i=0; i<bombs.length; i++){
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);

            boolean[] vis = new boolean[bombs.length];
            vis[i] = true;

            int count = 1;

            while(q.size()>0){
                int rm = q.poll();
                for(int j=0; j<bombs.length; j++){
                    if(!vis[j] && isInRange(bombs[rm], bombs[j])){
                        vis[j] = true;
                        q.offer(j);
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private boolean isInRange(int[] arr1, int[] arr2){
        long dx = arr1[0] - arr2[0];
        long dy = arr1[1] - arr2[1];
        long r = arr1[2];
        long dist = dx * dx + dy * dy;
        return dist <= r * r;
    }
}