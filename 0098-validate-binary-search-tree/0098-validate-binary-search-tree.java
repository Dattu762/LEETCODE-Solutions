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

    private TreeNode prev = null;
    /* Validates if the tree is a BST using inorder traversal 
    Because the left will be previous for root and root will be previous for right*/
    public boolean isValidBST(TreeNode root) {
        /* Base case: empty tree is valid */
        if (root == null) {
            return true;
        }
        
        /* Check left subtree recursively */
        if (!isValidBST(root.left)) {
            return false;
        }
        
        /* Compare current node with the previously visited node 
        the left will be previous for root and root will be previous for right*/
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        
        /* Update previous node to current before moving right */
        prev = root;
        
        /* Check right subtree recursively */
        return isValidBST(root.right);
    }
}