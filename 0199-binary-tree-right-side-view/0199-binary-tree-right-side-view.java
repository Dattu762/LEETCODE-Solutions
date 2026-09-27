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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        

        while(!queue.isEmpty()){
            
            boolean found=false;
            int s=queue.size();
            while(s>0){
                TreeNode cur=queue.poll();
                if(found==false){
                    found=true;
                    res.add(cur.val);
                }

                if(cur.right!=null) queue.add(cur.right);
                if(cur.left!=null) queue.add(cur.left);

                s--;
            }
        }

        return res;
    }
}