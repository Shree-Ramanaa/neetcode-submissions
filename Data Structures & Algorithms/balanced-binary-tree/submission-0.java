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
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        
        return dfs(root)[0] == 1;
    }

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[] {1, 0};
        }

        int[] lt = dfs(root.left);
        int[] rt = dfs(root.right);
        if(lt[0] == 0 || rt[0] == 0 || Math.abs(lt[1] - rt[1]) > 1){
            return new int[]{0,0};
        }

        return new int[]{1, Math.max(lt[1],rt[1]) + 1};
    }
}
