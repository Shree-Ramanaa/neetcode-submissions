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
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;

        maxDepth(root);
        return ans;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.right);
        int rt = maxDepth(root.left);
        ans = Math.max(ans, left + rt);
        return Math.max(left, rt) + 1;
    }

}
