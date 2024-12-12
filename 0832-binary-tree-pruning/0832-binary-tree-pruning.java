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
    public TreeNode pruneTree(TreeNode root) {
        boolean res = prune(root);
        if(res)
            return null;
        return root;
    }

    private boolean prune(TreeNode root){
        if(root == null)
            return true;
        
        boolean left = prune(root.left);
        boolean right = prune(root.right);
        if(left)
            root.left = null;
        if(right)
            root.right = null;
        if(left && right && root.val==0)
            return true;
        return false;
    }
}