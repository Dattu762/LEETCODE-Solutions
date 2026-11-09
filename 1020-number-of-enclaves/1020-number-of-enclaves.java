// class Solution {
//     public int numEnclaves(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;
 
//         // Remove boundary-connected land from the left and right edges.
//         for (int row = 0; row < rows; row++) {
//             dfs(row, 0, grid);
//             dfs(row, cols - 1, grid);
//         }
 
//         // Remove boundary-connected land from the top and bottom edges.
//         for (int col = 0; col < cols; col++) {
//             dfs(0, col, grid);
//             dfs(rows - 1, col, grid);
//         }
 
//         int enclaves = 0;
 
//         // Count the remaining land cells.
//         for (int row = 0; row < rows; row++) {
//             for (int col = 0; col < cols; col++) {
//                 enclaves += grid[row][col];
//             }
//         }
 
//         // Return the number of enclave cells.
//         return enclaves; 

//     }
//     // Removes all land cells connected to the current boundary land cell.
//     private void dfs(int row, int col, int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;
 
//         // Base case: stop if the cell is outside the grid or is water.
//         if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
//             return;
//         }
 
//         // Mark the current land cell as visited by changing it to water.
//         grid[row][col] = 0;
 
//         // Move to the upper cell.
//         dfs(row - 1, col, grid);
 
//         // Move to the lower cell.
//         dfs(row + 1, col, grid);
 
//         // Move to the left cell.
//         dfs(row, col - 1, grid);
 
//         // Move to the right cell.
//         dfs(row, col + 1, grid);
//     }
// }

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int v[][] = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && v[i][j]==0){
                    int res = dfs(i, j, grid, v);
                    if(res != -1)
                        count+=res;
                }
            }
        }
        return count;
    }

    public static int dfs(int i, int j, int[][] grid, int v[][]) {
        if(j<0 || j>=grid[0].length || i<0 || i>=grid.length){
            return -1;
        }

        if(grid[i][j] == 1 && v[i][j]==0) {
            v[i][j] = 1;
            int left = dfs(i, j-1, grid, v);
            int right = dfs(i, j+1, grid, v);
            int top = dfs(i-1, j, grid, v);
            int bottom = dfs(i+1, j, grid, v);
            if(left == -1 || right == -1 || top == -1 || bottom == -1){
                return -1;
            }
            return left + right + top + bottom + 1;
        }
        return 0;
        
    }
}