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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> pq = new LinkedList<>();

        if(root == null)
            return ans;
        
        pq.offer(root);
        while(pq.size()>0){
            int size = pq.size();
            double sum = 0.0;
            for(int i=0; i<size; i++){
                TreeNode rm = pq.poll();
                sum += rm.val;

                if(rm.left!=null)
                    pq.offer(rm.left);
                if(rm.right!=null)
                    pq.offer(rm.right); 
            }
            double avg = sum/size;
            ans.add(avg);
        }
        return ans;
    }
}