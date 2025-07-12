class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int prev = intervals[0][1];
        int start = intervals[0][0];
        List<int[]> ans = new ArrayList<>();
        for(int i=0; i<intervals.length;i++){
            if(intervals[i][0] > prev){
                ans.add(new int[]{start, prev});
                start = intervals[i][0];
            }
            prev = Math.max(intervals[i][1], prev);
        }
        ans.add(new int[]{start,prev});
        
        int[][] result = new int[ans.size()][];
        for(int i=0; i<result.length; i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}