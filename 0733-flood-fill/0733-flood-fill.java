class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image.length==0) return image;
        int[][] vis=new int[image.length][image[0].length];
        int pixel=image[sr][sc];
        dfs(image, vis, sr,sc, color, pixel);
        //int[][] adj=new int[][]{(1,0),(-1,0),(0,1),(0,-1)};
        return image;
    }

    private void dfs(int[][] image, int[][] vis, int sr, int sc, int color,int pixel){
        if( sc<0 || sc>=image[0].length || sr<0 || sr>=image.length || vis[sr][sc]==1 ) return;
        
        
        if(image[sr][sc]==pixel && vis[sr][sc]==0){
            vis[sr][sc]=1;
            image[sr][sc]=color;
            dfs(image,vis,sr+1,sc, color,pixel);
            dfs(image,vis,sr-1,sc, color,pixel);
            dfs(image,vis,sr,sc+1, color,pixel);
            dfs(image,vis,sr,sc-1, color,pixel);
        }
        
        
    }
}