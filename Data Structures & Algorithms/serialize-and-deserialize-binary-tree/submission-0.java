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
        if(root == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode node = q.poll();
                if(node == null){
                    sb.append("N,");
                }else{
                    sb.append(node.val + ",");
                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }

        String[] tokens = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        
        while (!q.isEmpty() && i < tokens.length) {
            TreeNode node = q.poll();
            
            // Left child
            if (!tokens[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(tokens[i]));
                q.offer(node.left);
            }
            i++;
            
            // Right child
            if (i < tokens.length && !tokens[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(tokens[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
