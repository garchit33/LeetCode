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
    class Pair {
        int depth;
        int val;
        Pair(int depth, int val){
            this.depth = depth;
            this.val = val;
        }
    }
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    List<List<Integer>> ans;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ans = new ArrayList<>();
        Map<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        traverse(root, 0, map, 0);
        int len = max-min+1;
        for(int i=0; i<len; i++){
            ans.add(new ArrayList<>());
        }

        min = Math.abs(min);
        for(int key : map.keySet()){
            List<Integer> list = ans.get(key+min);
            PriorityQueue<Pair> pq = map.get(key);
            while(pq.size()>0){
                list.add(pq.poll().val);
            }
        }
        return ans;
    }

    private void traverse(TreeNode root, int level, Map<Integer, PriorityQueue<Pair>> map, int d){
        if(root == null)
            return;
        min = Math.min(level,min);
        max = Math.max(level,max);

        PriorityQueue<Pair> pq = map.getOrDefault(level, new PriorityQueue<>((a,b) -> a.depth == b.depth ? a.val-b.val : a.depth-b.depth));
        pq.add(new Pair(d, root.val));
        map.put(level,pq);
        traverse(root.left, level-1, map, d+1);
        traverse(root.right, level+1, map, d+1);
    }
}