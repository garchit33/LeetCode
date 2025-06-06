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
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root){
        if(root == null)
            return;
        
        dfs(root.left);
        dfs(root.right);

        if(root.left != null){
            if(root.left.left == null & root.left.right == null){
                sum += root.left.val;
            }
        }
    }
}