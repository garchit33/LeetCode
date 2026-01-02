class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        for(int[] b : bookings){
            int first = b[0]-1;
            int last = b[1];
            int seats = b[2];
            arr[first] += seats;
            if(last < n)
                arr[last] -= seats;
        }

        for(int i=1; i<n; i++){
            arr[i] = arr[i] + arr[i-1];
        }
        return arr;
    }
}