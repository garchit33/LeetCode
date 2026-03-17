class Solution {
    int mergeSort(int[] arr, int low, int high){
        if(low == high)
            return 0;

        int mid = low + (high-low)/2;
        int left = mergeSort(arr, low, mid);
        int right = mergeSort(arr, mid+1, high);
        int curr = countPairs(arr, low, mid, high);
        merge(arr, low, mid, high); 
        return left+right+curr;
    }

    void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        
        int left = low;
        int right = mid+1;
        int x=0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[x++] = arr[left];
                left++;
            }else {
                temp[x++] = arr[right];
                right++;
            }
        }

        while(left <= mid){
            temp[x++]= arr[left];
            left++;
        }

        while(right <= high){
            temp[x++] = arr[right];
            right++;
        }

        for(int i=low; i<=high; i++){
            arr[i] = temp[i-low];
        }
    }

    int countPairs(int[] arr, int low, int mid, int high){
        int right = mid+1;
        int count = 0;
        for(int i=low; i<=mid; i++){
            while(right <= high && arr[i] > 2L*arr[right])
                right++;

            count += (right - (mid+1));
        }
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}