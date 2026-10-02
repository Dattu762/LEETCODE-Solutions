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

    private TreeNode previous;

    // Flattens the tree using reverse
    // preorder and recursion.
    public void flatten(TreeNode root) {

        previous = null;
 
        reversePreorder(root);
        
    }

    private void reversePreorder(TreeNode root) {
        if (root == null) {
            return;
        }
 
        reversePreorder(root.right);
        reversePreorder(root.left);
 
        // previous is the node that must follow
        // the current node in normal preorder.
        root.right = previous;
        root.left = null;
 
        previous = root;
    }
}