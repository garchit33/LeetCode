class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int r = triangle.size();
        int c = triangle.get(r-1).size();
        int[][] dp = new int[r][c];
        for(int[] i : dp)
            Arrays.fill(i, Integer.MIN_VALUE);

        return find(triangle, 0, 0, dp);
    }

    private int find(List<List<Integer>> list, int i, int j, int[][] dp){
        if(i == list.size()-1)
            return list.get(i).get(j);

        if(dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];

        int res1 = find(list, i+1, j, dp);
        int res2 = find(list, i+1, j+1, dp);

        return dp[i][j] = Math.min(res1, res2) + list.get(i).get(j);
    }
}