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
class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0){
            TreeNode rm = queue.peek();
            if(rm.left!=null){
                queue.offer(rm.left);
            }
            if(rm.right!=null){
                queue.offer(rm.right);
                queue.poll();
            }
            if(rm.left == null || rm.right == null)
                break;
        }            
    }
    
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode top = queue.peek();
        if(top.left == null){
            top.left = node;
        }else {
            top.right = node;
            queue.poll();
        }
        queue.offer(node);
        return top.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */