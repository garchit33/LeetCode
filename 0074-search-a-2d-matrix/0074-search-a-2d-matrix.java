class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        for(int nums[] : matrix){
            int ele = binarySearch(nums, target);
            if(ele != -1){
                found = true;
                break;
            }
        }
        return found;
    }

    private int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }
}