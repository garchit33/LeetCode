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
    public TreeNode reverseOddLevels(TreeNode root) {
        int level=1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> reverse = new ArrayList<>();
        while(q.size()>0){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode rm = q.poll();
                if(rm.left!=null){
                    list.add(rm.left.val);
                    q.offer(rm.left);
                }
                if(rm.right!=null){
                    q.offer(rm.right);
                    list.add(rm.right.val);
                }
                if(level%2==0){
                    int x = rm.val;
                    rm.val = reverse.get(reverse.size()-i-1);
                    reverse.add(i,x);
                }
            }
            reverse=list;
            level++;
        }
        return root;
    }
}