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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N,";
        }

        String str = root.val + ",";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "N,") {
            return null;
        }

        String[] tokens = data.split(",");
        int[] indx = new int[]{0};

        return deserialize(tokens, indx);
    }

    private TreeNode deserialize(String[] tokens, int[] index){
        if(tokens[index[0]].equals("N")){
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(tokens[index[0]++]));
        node.left = deserialize(tokens, index);
        node.right = deserialize(tokens, index);

        return node;
    }
}
