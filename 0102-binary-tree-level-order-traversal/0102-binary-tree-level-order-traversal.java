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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        while(pq.size() > 0){
            int size = pq.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode rm = pq.poll();
                list.add(rm.val);

                if(rm.left!=null)
                    pq.offer(rm.left);
                if(rm.right!=null)
                    pq.offer(rm.right);
            }
            result.add(list);
        }
        return result;
    }
}