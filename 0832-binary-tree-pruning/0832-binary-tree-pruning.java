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

    private boolean prune(TreeNode node){
        if(node == null){
            return true;
        }
        boolean left = prune(node.left);
        boolean right = prune(node.right);
        if(left)
            node.left = null;
        if(right)
            node.right = null;
        if(left && right && node.val==0)
            return true;
        
        return false;
    }
}