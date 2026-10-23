class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid,m,n);
                    island++;
                }
            }
        }
        return island;
    }
    public void dfs(int i,int j,char grid[][],int n,int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';

        dfs(i+1,j,grid,n,m);
        dfs(i,j+1,grid,n,m);
        dfs(i-1,j,grid,n,m);
        dfs(i,j-1,grid,n,m);
    }

}