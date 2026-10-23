class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            if(grid[i][0] == 1){
                dfs(i,0,grid,m,n);
            }
            if(grid[i][n-1] == 1){
                dfs(i,n-1,grid,m,n);
            }
        }

        for(int j=0;j<n;j++){
            if(grid[0][j] == 1){
                dfs(0,j,grid,m,n);
            }
            if(grid[m-1][j] == 1){
                dfs(m-1,j,grid,m,n);
            }
        }

        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,int grid[][],int n ,int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] != 1){
            return;
        }
        grid[i][j] = 0;

        dfs(i+1,j,grid,n,m);
        dfs(i,j+1,grid,n,m);
        dfs(i-1,j,grid,n,m);
        dfs(i,j-1,grid,n,m);
    }

}