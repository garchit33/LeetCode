class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];
        for(int[] arr : trust){
            indegree[arr[1]]++;
            indegree[arr[0]]--;
        }

        for(int i=1; i<=n; i++){
            if(indegree[i] == n-1)
                return i;
        }
        return -1;
    }
}