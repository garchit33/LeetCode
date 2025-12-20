class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();

        for(int i=0; i<k; i++){
            available.add(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[] count = new int[k];

        int max = 0;
        for(int i=0; i<arrival.length; i++){
            int time = arrival[i];
            int duration = load[i];

            while(pq.size()>0 && pq.peek()[0] <= time){
                int[] rm = pq.poll();
                available.add(rm[1]);
            }

            if(available.isEmpty())
                continue;

            Integer assigned = available.ceiling(i%k);
            if(assigned == null){
                assigned = available.first();
            }

            available.remove(assigned);
            pq.offer(new int[]{time + duration, assigned});
            count[assigned]++;
            max = Math.max(max, count[assigned]);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<k; i++){
            if(count[i] == max)
                ans.add(i);
        }

        return ans;
    }

}