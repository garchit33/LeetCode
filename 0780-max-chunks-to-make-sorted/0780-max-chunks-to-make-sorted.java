class Solution {
    public int maxChunksToSorted(int[] arr) {
        int sum = 0;
        int expectedSum = 0;
        int chunks = 0;
        for(int i=0; i<arr.length; i++){
            expectedSum+=i;
            sum+=arr[i];
            if(sum == expectedSum)
                chunks++;
        }
        return chunks;   
    }
}