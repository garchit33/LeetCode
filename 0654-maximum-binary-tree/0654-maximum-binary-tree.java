/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree (nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int begin, int end){
        if(begin>end)
            return null;
        int maxIdx = getMax(nums,begin,end);
        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = buildTree(nums,begin,maxIdx-1);
        node.right = buildTree(nums, maxIdx+1, end);
        return node;
    }

    private int getMax(int[] nums, int l, int r){
        int max = nums[l];
        int idx = l;
        while(l<=r){
            if(nums[l] > max){
                max = nums[l];
                idx = l;
            }
            l++;
        }
        return idx;
    }
}