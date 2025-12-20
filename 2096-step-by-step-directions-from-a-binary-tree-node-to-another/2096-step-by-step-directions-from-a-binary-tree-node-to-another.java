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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> pathToStart = new ArrayList<>();
        List<String> pathToDest = new ArrayList<>();
        find(root, startValue, pathToStart);
        find(root, destValue, pathToDest);

        int commonPath = 0;
        while(commonPath < pathToStart.size() && commonPath < pathToDest.size() 
        && pathToStart.get(commonPath).equals(pathToDest.get(commonPath))){
            commonPath++;
        }

        List<String> ans = new ArrayList<>();
        for(int i=0; i<pathToStart.size()-commonPath; i++){
            ans.add("U");
        }

        ans.addAll(pathToDest.subList(commonPath, pathToDest.size()));

        return String.join("",ans);

    }

    private boolean find(TreeNode root, int target, List<String> list){
        if(root == null)
            return false;

        if(root.val == target){
            return true;
        }

        list.add("L");
        if(find(root.left, target, list)){
            return true;
        }
        list.remove(list.size()-1);

        list.add("R");
        if(find(root.right, target, list)){
            return true;
        }
        list.remove(list.size()-1);

        return false;
    }
}