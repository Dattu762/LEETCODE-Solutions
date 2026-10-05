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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        TreeNode root1=root;
        while(root!=null){
            if(root.val==key){
                if(root.right!=null){
                    TreeNode left=root.left;
                    TreeNode right=root.right;
                    while(right.left!=null){
                        right=right.left;
                    }
                    right.left=left;
                    return root.right;
                }
                return root.left;
            }
            else if(root.val<key){
                if(root.right!=null && root.right.val==key){
                    if(root.right.right!=null){
                        TreeNode right=root.right.right;
                        TreeNode left=root.right.left;
                        root.right=right;
                        while(right.left!=null){
                            right=right.left;
                        }
                        right.left=left;
                    }else{
                        TreeNode left=root.right.left;
                        root.right=left;
                    }
                }
                root=root.right;

            }else{
                if(root.left!=null && root.left.val==key){
                    if(root.left.right!=null){
                        TreeNode right=root.left.right;
                        TreeNode left=root.left.left;
                        root.left=right;
                        while(right.left!=null){
                            right=right.left;
                        }
                        right.left=left;
                    }else{
                        TreeNode left=root.left.left;
                        root.left=left;
                    }
                }
                root=root.left;
            }

        }

        return root1;
    }
}