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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int begin, int end){
        if(begin>end)
            return null;

        int mid = begin+(end-begin)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, begin, mid-1);
        node.right = buildTree(nums, mid+1, end);

        return node;
    }
}