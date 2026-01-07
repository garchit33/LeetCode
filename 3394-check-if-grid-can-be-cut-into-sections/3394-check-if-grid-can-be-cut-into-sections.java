class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a,b) -> a[0]==b[0] ? a[2]-b[2] : a[0]-b[0]);
        boolean x = check(rectangles, true);
        if(x)
            return true;
        
        Arrays.sort(rectangles, (a,b) -> a[1]==b[1] ? a[3]-b[3] : a[1]-b[1]);
        return check(rectangles, false);
    }

    private boolean check(int[][] rectangle, boolean isX){
        int end = isX ? rectangle[0][2] : rectangle[0][3];
        int count = 0;
        for(int i=1; i<=rectangle.length-1; i++){
            if(end <= (isX ? rectangle[i][0] : rectangle[i][1])){
                count++;
            }
            if(count == 2)
                return true;
            end = Math.max(end, isX ? rectangle[i][2] : rectangle[i][3]);
        }
        return false;
    }
}