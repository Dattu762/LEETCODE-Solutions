/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /* Continue searching as long as there are nodes to inspect */
        while (root != null) {
            /* Move left if both targets are strictly smaller */
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            /* Move right if both targets are strictly larger */
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            /* The split point is found when the paths diverge */
            else {
                return root;
            }
        }
        
        return null;

    }
}