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
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int begin, int end){
        if(begin>end)
            return null;
        
        int max = getMaxIdx(nums, begin, end);
        TreeNode node = new TreeNode(nums[max]);
        node.left = buildTree(nums, begin, max-1);
        node.right = buildTree(nums, max+1, end);
        return node;
    }

    private int getMaxIdx(int[] nums, int left, int right){
        int max = nums[left];
        int idx = left;
        while(left <= right){
            if(nums[left] > max){
                max = nums[left];
                idx = left;
            }
            left++;
        }
        return idx;
    }
}