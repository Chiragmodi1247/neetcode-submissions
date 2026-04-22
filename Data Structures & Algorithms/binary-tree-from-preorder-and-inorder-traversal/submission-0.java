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
    int preOrderIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int inLeft, int inRight) {
        if(inLeft > inRight) return null;

        int curr = preorder[preOrderIndex++];
        int mid = inorderMap.get(curr);
        TreeNode root = new TreeNode(curr);
        root.left = build(preorder, inLeft, mid-1);
        root.right = build(preorder, mid+1, inRight);
        return root;
    }
}
