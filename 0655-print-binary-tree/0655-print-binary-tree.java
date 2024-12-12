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
    class Pair{
        int row;
        int col;
        TreeNode node;
        Pair(int row, int col, TreeNode node){
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        int height = depth(root)-1;
        int totalCol = (int) Math.pow(2, height+1)-1;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,totalCol/2,root));
        while(queue.size()>0){
            int size = queue.size();
            List<String> list = new ArrayList<>();
            for(int i=0; i<totalCol; i++){
                list.add("");
            }
            for(int i=0; i<size; i++){
                Pair rm = queue.poll();
                int r = rm.row;
                int c = rm.col;
                list.set(c,String.valueOf(rm.node.val));

                if(rm.node.left != null)
                    queue.offer(new Pair(r+1, c-(int) Math.pow(2,height-r-1), rm.node.left));
                if(rm.node.right != null)
                    queue.offer(new Pair(r+1, c+(int) Math.pow(2,height-r-1), rm.node.right));
            }
            ans.add(list);
        }
        return ans;
    }

    private int depth(TreeNode root){
        if(root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right)+1;
    }
}