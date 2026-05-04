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
        int[] res = new int[2];
        res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root){
        if(root == null)return new int[]{0, 0};
        if(root.left == null && root.right == null){
            return new int[]{root.val, 0};
        }
        else{
            int[] left = new int[2];
            int[] right = new int[2];
            if(root.left!=null)left = dfs(root.left);
            if(root.right!=null)right = dfs(root.right);

            int rob1 = left[1] + right[1] + root.val;


            int rob2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            return new int[]{rob1, rob2};
        }
    }
}