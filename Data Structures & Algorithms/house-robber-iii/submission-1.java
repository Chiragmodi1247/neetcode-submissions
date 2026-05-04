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
    
   
    public int rob(TreeNode root) {
        int[] a = dfs(root);
        return Math.max(a[0] , a[1]);
    }
    public int[] dfs(TreeNode root) {
    if (root == null) return new int[]{0, 0};

    int[] left = dfs(root.left);
    int[] right = dfs(root.right);

    int[] res = new int[2];
    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // nu iei root
    res[1] = root.val + left[0] + right[0]; // iei root

    return res;
}
}