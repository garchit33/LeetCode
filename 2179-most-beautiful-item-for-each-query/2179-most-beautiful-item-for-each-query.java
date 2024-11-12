class Solution {
    // public int[] maximumBeauty(int[][] items, int[] queries) {
    // PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
    // int arr[] = new int[queries.length];
    // for (int i = 0; i < queries.length; i++) {
    // for (int nums[] : items) {
    // // System.out.println("in items "+nums[0]);
    // if (nums[0] <= queries[i]){
    // // System.out.println("in queue "+nums[1]);
    // pq.offer(nums[1]);
    // }
    // }
    // int num = 0;
    // if(pq.size()>0){
    // // System.out.println("num "+num);
    // num = pq.poll();
    // arr[i] = num;
    // pq.clear();
    // }
    // }
    // return arr;
    // }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b) -> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int max = 0;
        int[] ans = new int[queries.length];

        for(int i=0; i<items.length; i++){
            max = Math.max(items[i][1],max);
            items[i][1]=max;
        }

        for(int i=0; i<queries.length; i++){
            ans[i] = find(items, queries[i]);
        }

        return ans;
    }

    private int find(int[][] items, int price){
        int start = 0;
        int end = items.length-1;
        int ans=0;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(price >= items[mid][0]){
                ans = items[mid][1];
                start = mid+1;
            } else
                end = mid-1;
        }
        return ans;
    }
}