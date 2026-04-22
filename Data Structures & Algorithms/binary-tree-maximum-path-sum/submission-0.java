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
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalMax;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));
        int pathThroughMe = node.val + leftGain + rightGain;
        globalMax = Math.max(globalMax, pathThroughMe);
        return node.val + Math.max(leftGain, rightGain);
    }
}
