class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        Integer[][] dp = new Integer[nums1.length][nums2.length];

        return find(nums1, nums2, 0,0, dp);
    }

    private int find(int[] nums1, int[] nums2, int i, int j, Integer[][] dp){
        if(i>=nums1.length || j>=nums2.length){
            return Integer.MIN_VALUE;
        }

        if(dp[i][j] != null)
            return dp[i][j];

        int ans = Integer.MIN_VALUE;

        ans = Math.max(ans, nums1[i]*nums2[j]+Math.max(0, find(nums1, nums2, i+1,j+1,dp)));

        ans = Math.max(ans, find(nums1, nums2, i, j+1,dp));
        ans = Math.max(ans, find(nums1, nums2, i+1, j, dp));

        return dp[i][j] = ans;
    }
}