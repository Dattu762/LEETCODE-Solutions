class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected.length==0) return 0;
        int res=0;
        int[] vis=new int[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(vis[i]==0){
                dfs(isConnected, vis, i);
                res++;
            }
        }
        return res;
    }

    public void dfs(int[][] arr, int[] vis, int node){
        if(vis[node]==1) return;
        vis[node]=1;
        for(int i=0;i<arr[node].length;i++){
            if(arr[node][i]==1) dfs(arr, vis, i);
        }
    }
}