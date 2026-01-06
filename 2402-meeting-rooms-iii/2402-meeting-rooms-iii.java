class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);

        PriorityQueue<Integer> available = new PriorityQueue<>();
        int count[] = new int[n];
        int max = 0;

        for(int i=0; i<n; i++){
            available.offer(i);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->a[0]==b[0]?Long.compare(a[1],b[1]):Long.compare(a[0],b[0]));
        for(int i=0; i<meetings.length; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            int diff = end-start;

            while(pq.size() > 0 && pq.peek()[0] <= start){
                long[] rm = pq.poll();
                available.offer((int) rm[1]);
            }

            if(available.size()>0){
                int rm = available.poll();
                pq.offer(new long[]{end, rm});
                count[rm]++;
            }else {
                long[] rm = pq.poll();
                pq.offer(new long[]{rm[0]+diff,rm[1]});
                count[(int)rm[1]]++;
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            if(count[i] > max) {
                ans = i;
                max = count[i];
            }
        }
        return ans;
    }
}