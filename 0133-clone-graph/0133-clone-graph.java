/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer,Node> map = new HashMap<>();
        return solve(map, node);
    }

    private Node solve(Map<Integer, Node> map, Node node){
        if(node == null)
            return null;
        
        if(map.containsKey(node.val))
            return map.get(node.val);
        
        Node root = new Node(node.val);
        map.put(node.val, root);
        List<Node> nbrs = root.neighbors;

        for(Node nbr : node.neighbors){
            nbrs.add(solve(map, nbr));
        }

        return root;
    }
}