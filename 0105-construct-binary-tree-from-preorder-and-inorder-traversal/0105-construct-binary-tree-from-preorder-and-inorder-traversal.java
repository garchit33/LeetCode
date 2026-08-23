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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return constructTree(preorder, 0, n-1, inorder, 0, n-1);
    }

    private TreeNode constructTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        if(pStart > pEnd){
            return null;
        }

        int count = 0;
        int pos = iStart;
        while(preorder[pStart] != inorder[pos]){
            pos++;
            count++;
        }

        TreeNode node = new TreeNode(preorder[pStart]);
        node.left = constructTree(preorder, pStart+1, pStart + count, inorder, iStart, pos-1);
        node.right = constructTree(preorder, pStart+count+1, pEnd, inorder, pos+1, iEnd);

        return node;
    }
}