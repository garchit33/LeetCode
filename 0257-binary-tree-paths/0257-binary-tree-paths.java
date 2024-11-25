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
    List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        traverseTree(root, "");
        return list;
    }

    private void traverseTree(TreeNode root, String str){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            str+=root.val;
            list.add(str);
            return;
        }

        String s = str + root.val + "->";
        traverseTree(root.left, s);
        traverseTree(root.right, s);
    }
}