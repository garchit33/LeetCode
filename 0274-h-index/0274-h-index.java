class Solution {
    public int hIndex(int[] citations) {
        int[] arr = new int[citations.length+1];
        for(int i=0; i<citations.length; i++){
            if(citations[i] >= arr.length){
                arr[citations.length]++;
            }else{
                arr[citations[i]]++;
            }
        }

        int sum = 0;
        for(int i = arr.length-1; i>=0; i--){
            sum+=arr[i];
            if(i<=sum){
                return i;
            }
        }
        return 0;
    }
}