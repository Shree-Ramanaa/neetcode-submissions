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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lvlElements = new ArrayList<>();

        if(root == null){
            return lvlElements;
        } 

        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        while(!dq.isEmpty()){
            int size = dq.size();

            while(size-- > 0){
                TreeNode node = dq.pollFirst();
                if(size == 0){
                    lvlElements.add(node.val);
                }

                if(node.left != null)dq.offer(node.left);
                if(node.right != null)dq.offer(node.right);
            }
        }

        return lvlElements;
    }
}