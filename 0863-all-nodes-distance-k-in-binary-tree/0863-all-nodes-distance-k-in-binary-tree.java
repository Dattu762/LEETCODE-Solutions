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
    // Builds child-to-parent relationships
    // using level-order traversal.
    private void buildParentTrack(TreeNode root, Map<TreeNode, TreeNode> parentTrack
    ) {
        Queue<TreeNode> nodesQueue =new LinkedList<>();

        nodesQueue.offer(root);
        // The root has no parent, so null
        // represents the end of upward movement.
        parentTrack.put(root, null);

        while (!nodesQueue.isEmpty()) {
            TreeNode node = nodesQueue.poll();

            if (node.left != null) {
                parentTrack.put(node.left,node);
                nodesQueue.offer(node.left);
            }

            if (node.right != null) {
                parentTrack.put(node.right,node);
                nodesQueue.offer(node.right);
            }
        }
    }

    // Performs BFS using left, right,
    // and parent connections.
    public List<Integer> distanceK(TreeNode root,TreeNode target,int K) 
    {
        List<Integer> answer =new ArrayList<>();

        if (root == null) {
            return answer;
        }

        // parentTrack stores the parent of
        // every node to allow upward movement.
        Map<TreeNode, TreeNode> parentTrack =new HashMap<>();

        buildParentTrack(root,parentTrack);

        Queue<TreeNode> nodesQueue =new LinkedList<>();

        nodesQueue.offer(target);

        // visited prevents a node from being
        // reached again through another direction.
        Set<TreeNode> visited =new HashSet<>();

        visited.add(target);

        // currLevel represents the distance
        // of the current BFS level from target.
        int currLevel = 0;

        while (!nodesQueue.isEmpty()) {

            // The current queue already represents
            // nodes exactly K edges away.
            if (currLevel == K) {
                break;
            }

            int levelSize =nodesQueue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node =nodesQueue.poll();

                if (node.left != null &&!visited.contains(node.left)) 
                {
                    visited.add(node.left);
                    nodesQueue.offer(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) 
                {
                    visited.add(node.right);
                    nodesQueue.offer(node.right);
                }

                TreeNode parent = parentTrack.get(node);

                // Parent links allow BFS to
                // move upward toward ancestors.
                if (parent != null && !visited.contains(parent)) 
                {
                    visited.add(parent);
                    nodesQueue.offer(parent);
                }
            }

            // A complete BFS level corresponds
            // to one additional edge.
            currLevel++;
        }

        while (!nodesQueue.isEmpty()) {
            answer.add(nodesQueue.poll().val);
        }

        return answer;
    }
}