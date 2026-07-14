class Solution {
    class DistanceComparator implements Comparator<double[]> {
        public int compare(double[] a, double[] b){
            return b[0]>a[0]?1:-1;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new DistanceComparator());
        for(int i=0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            double dis = Math.sqrt(x*x + y*y);
            pq.offer(new double[]{dis, i});

            if(pq.size() > k)
                pq.poll();
        }

        int[][] ans = new int[k][2];
        int x = 0;
        while(pq.size() > 0){
            ans[x++] = points[(int) pq.poll()[1]];
        }

        return ans;
    }
}