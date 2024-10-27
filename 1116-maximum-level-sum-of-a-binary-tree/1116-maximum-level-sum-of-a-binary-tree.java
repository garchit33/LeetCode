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
    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int ans = 0;
        while(queue.size() > 0){
            int size = queue.size();
            int sum = 0;
            for(int i=0; i<size; i++){
                TreeNode rm = queue.poll();
                sum+=rm.val;

                if(rm.left!=null)
                    queue.offer(rm.left);
                if(rm.right!=null)
                    queue.offer(rm.right);
            }
            level++;
            if(sum > maxSum){
                maxSum = sum;
                ans = level;
            }
        }
        return ans;
    }
}