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
    int preOrderIdx;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 1)return new TreeNode(preorder[0]);
        preOrderIdx = 0;
        map = new HashMap<>();
        for(int i=0; i<preorder.length; i++){
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int leftIdx, int rightIdx){
        if(leftIdx > rightIdx)return null;

        TreeNode node = new TreeNode(preorder[preOrderIdx]);
        int inorderIdx = map.get(preorder[preOrderIdx++]);
        node.left = dfs(preorder, inorder, leftIdx, inorderIdx - 1);
        node.right = dfs(preorder, inorder, inorderIdx + 1, rightIdx);

        return node;
    }
}
