class Solution {
    long mod = (long)1e9+7;
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        long sumOfPackages = 0L;
        for(int p : packages){
            sumOfPackages += p;
        }

        long inf = (long) 1e11;
        long res = inf;

        for(int[] arr : boxes){
            Arrays.sort(arr);
            if(arr[arr.length-1] < packages[packages.length-1])
                continue;
            long curSum = 0;
            long i = 0;
            long j = 0;
            for(int box : arr){
                j = binarySearch(packages, box+1);
                curSum += (j-i)*box;
                i=j;
            }
            res = Math.min(res,curSum);
        }

        return res >= inf ? -1 : (int)((res-sumOfPackages)%mod);
    }

    private int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] < target){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return start;
    }
}