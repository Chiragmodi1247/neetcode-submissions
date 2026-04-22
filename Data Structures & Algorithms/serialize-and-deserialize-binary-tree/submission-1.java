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
    int parsingIndex = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "N";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> tokens = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(tokens);
    }

    private TreeNode buildTree(Queue<String> tokens) {
        String curr = tokens.poll();
        if(curr.equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = buildTree(tokens);
        root.right = buildTree(tokens);
        return root;
    }
}
