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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        find(root);
        return ans;
    }

    private int find(TreeNode root){
        if(root == null)
            return 0;
        
        int left = Math.max(0, find(root.left));
        int right = Math.max(0, find(root.right));

        ans = Math.max(ans, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}