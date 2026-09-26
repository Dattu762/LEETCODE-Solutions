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

    static class NodeInfo {
        TreeNode node;
        int row;
        int column;

        NodeInfo(
            TreeNode node,
            int row,
            int column
        ) {
            this.node = node;
            this.row = row;
            this.column = column;
        }
    }

    // Organizes nodes directly by
    // column, row, and sorted value.
    public List<List<Integer>> verticalTraversal(
        TreeNode root
    ) {
        if (root == null) {
            return new ArrayList<>();
        }

        // Outer TreeMap orders columns, inner
        // TreeMap orders rows, heap sorts ties.
        TreeMap<
            Integer,
            TreeMap<Integer, PriorityQueue<Integer>>
        > nodes = new TreeMap<>();

        Queue<NodeInfo> queue =
            new LinkedList<>();

        queue.offer(
            new NodeInfo(root, 0, 0)
        );

        // BFS carries the coordinate
        // of every visited node.
        while (!queue.isEmpty()) {
            NodeInfo current =
                queue.poll();

            nodes.putIfAbsent(
                current.column,
                new TreeMap<>()
            );

            nodes.get(current.column)
                .putIfAbsent(
                    current.row,
                    new PriorityQueue<>()
                );

            nodes.get(current.column)
                .get(current.row)
                .offer(current.node.val);

            // A left child moves one row down
            // and one column to the left.
            if (current.node.left != null) {
                queue.offer(
                    new NodeInfo(
                        current.node.left,
                        current.row + 1,
                        current.column - 1
                    )
                );
            }

            // A right child moves one row down
            // and one column to the right.
            if (current.node.right != null) {
                queue.offer(
                    new NodeInfo(
                        current.node.right,
                        current.row + 1,
                        current.column + 1
                    )
                );
            }
        }

        List<List<Integer>> answer =
            new ArrayList<>();

        // Nested iteration preserves column,
        // row, and ascending-value order.
        for (
            TreeMap<Integer, PriorityQueue<Integer>>
                rows : nodes.values()
        ) {
            List<Integer> columnValues =
                new ArrayList<>();

            for (
                PriorityQueue<Integer> values :
                rows.values()
            ) {
                while (!values.isEmpty()) {
                    columnValues.add(
                        values.poll()
                    );
                }
            }

            answer.add(columnValues);
        }

        return answer;
    }
}