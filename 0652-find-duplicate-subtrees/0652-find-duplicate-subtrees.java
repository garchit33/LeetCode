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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        dfs(root, ans, new HashMap<>());

        return ans;
    }

    private String dfs(TreeNode node, List<TreeNode> ans, Map<String, Integer> map){
        if(node == null){
            return " ";
        }
        String left = dfs(node.left, ans, map);
        String right = dfs(node.right, ans, map);
        String postorder = left +  " " + right + " " + node.val;
        map.put(postorder, map.getOrDefault(postorder, 0)+1);
        if(map.get(postorder) == 2){
            ans.add(node);
        }
        return postorder;
    }
}