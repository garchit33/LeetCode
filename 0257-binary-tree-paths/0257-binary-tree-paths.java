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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        traverseTree(root, "", ans);
        return ans;
    }

    private void traverseTree(TreeNode root, String str, List<String> ans){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            str+=root.val;
            ans.add(str);
            return;
        }

        String s = str + root.val + "->";
        traverseTree(root.left, s, ans);
        traverseTree(root.right, s, ans);
    }
}