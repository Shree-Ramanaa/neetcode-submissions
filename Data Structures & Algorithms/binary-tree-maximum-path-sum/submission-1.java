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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left < 0){
            left = 0;
        }

        if(right < 0){
            right = 0;
        }

        maxSum = Math.max(maxSum, root.val + right + left);
        maxSum = Math.max(maxSum, Math.max(root.val+right, root.val+left));

        return right > left ? root.val + right : root.val + left;
    }
}
