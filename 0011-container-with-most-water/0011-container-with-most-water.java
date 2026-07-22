class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while(l < r){
            int minH = Math.min(height[l], height[r]);
            ans = Math.max(ans, (r-l)*minH);
            if(height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }
}