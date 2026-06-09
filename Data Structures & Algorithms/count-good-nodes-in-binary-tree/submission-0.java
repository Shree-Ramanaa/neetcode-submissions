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

    public int goodNodes(TreeNode root) {
        countGoodNodes(root, -101);
        return ans;
    }

    private void countGoodNodes(TreeNode root, int maxVal){
        if(root == null){
            return;
        }

        if(root.val >= maxVal){
            ans++;
            maxVal = root.val;
        }
        
        countGoodNodes(root.left, maxVal);
        countGoodNodes(root.right, maxVal);
    }
}
