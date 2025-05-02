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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> pq = new LinkedList<>();

        if(root == null)
            return ans;

        pq.offer(root);
        int level = 1;
        while(pq.size()>0){
            int size = pq.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode rm = pq.poll();
                if(level%2 == 0){
                    list.add(0, rm.val);
                }else {
                    list.add(rm.val);
                }

                if(rm.left != null)
                    pq.offer(rm.left);
                
                if(rm.right != null)
                    pq.offer(rm.right);
            }
            ans.add(list);
            level++;
        }
        return ans;
    }
}