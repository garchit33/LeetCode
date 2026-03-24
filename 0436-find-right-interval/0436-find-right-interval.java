class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] firstEleArr = new int[intervals.length];
        int[] ans = new int[intervals.length];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<intervals.length; i++){
            firstEleArr[i] = intervals[i][0];
            map.put(intervals[i][0], i);
        }

        Arrays.sort(firstEleArr);

        for(int i=0; i<intervals.length; i++){
            int searchIdx = binarySearch(firstEleArr, intervals[i][1]);
            if(searchIdx == firstEleArr.length)
                ans[i] = -1;
            else
                ans[i] = map.get(firstEleArr[searchIdx]);
        }
        return ans;
    }

    private int binarySearch(int arr[], int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == arr[mid])
                return mid;
            if(target < arr[mid]){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return start;
    }
}