class Solution {
    public boolean isUgly(int n) {
        if(n<=0)
            return false;

        int[] arr = new int[]{2,3,5};
        for(int i=0; i<arr.length; i++){
            while(n % arr[i] == 0){
                n /= arr[i];
            }
        }

        return n==1;
    }
}