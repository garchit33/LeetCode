class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int prev = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] > prev){
                list.add(new int[]{start,prev});
                start = intervals[i][0];
            }
            prev = Math.max(prev, intervals[i][1]);
        }
        list.add(new int[]{start, prev});

        int[][] ans = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}