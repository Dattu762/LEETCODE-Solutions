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

    int kc=0;
    int kths=-1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return kths;
    }

    private void inorder(TreeNode root, int k){
        if(root==null || kc>=k) return;

        inorder(root.left,k);

        kc++;
        if(kc==k) kths=root.val;

        inorder(root.right,k);
    }
}