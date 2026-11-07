class Solution {
    public int numIslands(char[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        if(m==0) return 0;
        int res=0;
        int[][] vis= new int[m][n];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    bfs(grid,vis,i,j,directions);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int[][] vis, int i, int j,int[][] directions){
        if(vis[i][j]==1) return;
        vis[i][j]=1;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{i,j});
        while(!queue.isEmpty()){
            int[] arr=queue.poll();
            int m=arr[0];
            int n=arr[1];
            
            for(int[] direction : directions){
                int node1=m+direction[0];
                int node2=n+direction[1];
                if(node1>=0 && node1<grid.length && node2>=0 && node2<grid[0].length && 
                    grid[node1][node2]=='1' && vis[node1][node2]==0){
                        vis[node1][node2]=1;
                        queue.add(new int[]{node1,node2});
                    }
            }
            
        }
    }
}