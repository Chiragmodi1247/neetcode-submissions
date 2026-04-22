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
    private int[] buildLPS(String s) {
        int[] lps = new int[s.length()];
        int len = 0;
        int i = 1;
        while(i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    private boolean KMP(String s, String p) {
        int[] lps = buildLPS(s);
        int i=0,j=0;
        while(i < s.length()) {
            if(s.charAt(i) == p.charAt(j)) {
                i++;j++;
            }
            if(j == p.length()) return true;
            
            if (i < s.length() && s.charAt(i) != p.charAt(j)) {
                if (j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private String serialize(TreeNode root) {
        if (root == null)
        return "$#";
        return "$" + root.val + serialize(root.left) + serialize(root.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String S_root = serialize(root);
        String P_root = serialize(subRoot);

        return KMP(S_root, P_root);
    }
}
