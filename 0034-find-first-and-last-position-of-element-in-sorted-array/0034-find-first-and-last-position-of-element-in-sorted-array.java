class Solution {
    public int[] searchRange(int[] nums, int target) {
        int x = getElementPos(nums, target, true);
        int y = getElementPos(nums, target, false);
        return new int[]{x,y};
    }

    private int getElementPos(int[] arr, int target, boolean isFirstElement){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid]<target){
                start=mid+1;
            }else if(arr[mid]>target){
                end=mid-1;
            }else {
                ans = mid;
                if(isFirstElement)
                    end=mid-1;
                else
                    start=mid+1;
            }
        }
        return ans;
    }
}