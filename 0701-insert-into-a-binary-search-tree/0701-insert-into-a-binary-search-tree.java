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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode new1=new TreeNode(val);
        if(root==null) return new1;
        TreeNode root1=root;
        while(root!=null){
            if(root.val>val && root.left==null) {
                root.left=new1;
                break;
            }
            else if(root.val<val && root.right==null){
                root.right=new1;
                break;
            }
            else if(root.val>val) root=root.left;
            else root=root.right;
        }

        return root1;
    }
}