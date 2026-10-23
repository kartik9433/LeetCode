class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                 island =  Math.max(island,dfs(i,j,grid,m,n));
                    
                }
            }
        }
        return island;        
    }
    public int  dfs(int i,int j,int grid[][],int n,int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;

        return 1 + dfs(i+1,j,grid,n,m) + dfs(i,j+1,grid,n,m) + dfs(i-1,j,grid,n,m) + dfs(i,j-1,grid,n,m);
    }
}