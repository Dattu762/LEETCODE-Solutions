class Solution {
    // Marks boundary-connected cells using DFS.
    private void markSafe(int row, int col, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
 
        // Base case: stop for invalid cells and non-'O' cells.
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 'O') {
            return;
        }
 
        // Mark the current cell as safe.
        board[row][col] = '#';
 
        // Move to the upper cell.
        markSafe(row - 1, col, board);
 
        // Move to the lower cell.
        markSafe(row + 1, col, board);
 
        // Move to the left cell.
        markSafe(row, col - 1, board);
 
        // Move to the right cell.
        markSafe(row, col + 1, board);
    }
 
    // Captures surrounded regions using DFS.
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
 
        // Mark safe cells from the left and right borders.
        for (int row = 0; row < rows; row++) {
            markSafe(row, 0, board);
            markSafe(row, cols - 1, board);
        }
 
        // Mark safe cells from the top and bottom borders.
        for (int col = 0; col < cols; col++) {
            markSafe(0, col, board);
            markSafe(rows - 1, col, board);
        }
 
        // Flip captured cells and restore safe cells.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Captured cells are still marked as 'O'.
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
 
                // Safe cells were temporarily marked as '#'.
                else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }
}
