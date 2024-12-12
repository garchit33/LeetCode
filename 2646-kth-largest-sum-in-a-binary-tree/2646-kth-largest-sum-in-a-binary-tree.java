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
    class ValueCompare implements Comparator<Long> {
        public int compare(Long a, Long b){
            if(b>a)
                return 1;
            else if(b==a)
                return 0;
            else
                return -1;
        }
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(new ValueCompare());
        q.offer(root);
        while(q.size()>0){
            int size = q.size();
            long sum = 0;
            for(int i=0; i<size; i++){
                TreeNode rm = q.poll();
                sum+=rm.val;

                if(rm.left!=null)
                    q.offer(rm.left);
                if(rm.right!=null)
                    q.offer(rm.right);
            }
            pq.offer(sum);
        }
        if(pq.size()<k)
            return -1;
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.poll();
    }
}