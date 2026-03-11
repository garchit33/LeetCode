class Solution {
    public int[] twoSum(int[] arr, int target) {
        int idx1 = 0;
        int idx2 = 0;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int sum = arr[start] + arr[end];
            if(sum == target){
                idx1 = start+1;
                idx2 = end+1;
                break;
            }else if(sum > target){
                end = end - 1;
            }else {
                start = start + 1;
            }
        }

        return new int[]{idx1, idx2};
    }
}