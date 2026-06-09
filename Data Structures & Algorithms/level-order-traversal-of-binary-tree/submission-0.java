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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        } 

        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> lvlElements = new ArrayList<>();

            while(size-- > 0){
                TreeNode node = dq.pollFirst();
                lvlElements.add(node.val);

                if(node.left != null)dq.offer(node.left);
                if(node.right != null)dq.offer(node.right);
            }

            res.add(lvlElements);
        }

        return res;
    }
}
