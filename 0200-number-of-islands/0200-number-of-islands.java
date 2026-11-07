class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int v[][] = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && v[i][j]==0){
                    count++;
                    dfs(i, j, grid, v);
                }
            }
        }
        return count;
    }

    public static void dfs(int i, int j, char[][] grid, int v[][]) {
        if(j<0 || j>=grid[0].length || i<0 || i>=grid.length){
            return;
        }

        if(grid[i][j] == '1' && v[i][j]==0) {
            v[i][j] = 1;
            dfs(i, j-1, grid, v);
            dfs(i, j+1, grid, v);
            dfs(i-1, j, grid, v);
            dfs(i+1, j, grid, v);
        }
        
    }
}