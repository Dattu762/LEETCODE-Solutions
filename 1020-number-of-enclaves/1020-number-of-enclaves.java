class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
 
        // Remove boundary-connected land from the left and right edges.
        for (int row = 0; row < rows; row++) {
            dfs(row, 0, grid);
            dfs(row, cols - 1, grid);
        }
 
        // Remove boundary-connected land from the top and bottom edges.
        for (int col = 0; col < cols; col++) {
            dfs(0, col, grid);
            dfs(rows - 1, col, grid);
        }
 
        int enclaves = 0;
 
        // Count the remaining land cells.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                enclaves += grid[row][col];
            }
        }
 
        // Return the number of enclave cells.
        return enclaves; 

    }
    // Removes all land cells connected to the current boundary land cell.
    private void dfs(int row, int col, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
 
        // Base case: stop if the cell is outside the grid or is water.
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
            return;
        }
 
        // Mark the current land cell as visited by changing it to water.
        grid[row][col] = 0;
 
        // Move to the upper cell.
        dfs(row - 1, col, grid);
 
        // Move to the lower cell.
        dfs(row + 1, col, grid);
 
        // Move to the left cell.
        dfs(row, col - 1, grid);
 
        // Move to the right cell.
        dfs(row, col + 1, grid);
    }
}

