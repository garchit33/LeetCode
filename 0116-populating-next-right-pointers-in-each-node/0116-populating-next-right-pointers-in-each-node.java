/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size()>0){
            Node prev = null;
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node rm = queue.poll();
                rm.next = prev;

                if(rm.right != null)
                    queue.offer(rm.right);
                if(rm.left != null)
                    queue.offer(rm.left);
                
                prev = rm;
            }
        }
        return root;
    }
}