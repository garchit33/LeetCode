class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1, ans=0;
        while(l<r){
            int min = Math.min(height[l],height[r]);
            ans = Math.max(ans, (r-l)*min);
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return ans;
    }
}