class Solution {
    public int findCenter(int[][] edges) {
        int[] arr = new int[100001];
        for(int edge[] : edges){
            arr[edge[0]]++;
            arr[edge[1]]++;
        }

        for(int i=1; i<=edges.length+1; i++){
            if(arr[i] > 1){
                return i;
            }
        }
        return -1;
    }
}