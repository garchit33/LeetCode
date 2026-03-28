class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n+1];
        int i2=1, i3=1, i5=1;

        arr[1] = 1;
        for(int i=2; i<=n; i++){
            int i2UglyNum = arr[i2]*2;
            int i3UglyNum = arr[i3]*3;
            int i5UglyNum = arr[i5]*5;

            int min = Math.min(Math.min(i2UglyNum, i3UglyNum), i5UglyNum);
            arr[i] = min;

            if(min == i2UglyNum)
                i2++;
            if(min == i3UglyNum)
                i3++;
            if(min == i5UglyNum)
                i5++;
        }

        return arr[n];
    }
}