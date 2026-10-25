class Solution {
    public int uniquePathsIII(int[][] grid) {
        int sr = 0;
        int sc = 0;
        int zero = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }
                if(grid[i][j] == 0 || grid[i][j] == 1){
                    zero++;
                }
            }
        }
       return dfs(sr,sc,zero,grid);
        
    }
    public int dfs(int sr,int sc,int zero,int grid[][]){
        if(sr<0 || sc<0 || sr>=grid.length ||  sc>= grid[0].length || grid[sr][sc]==-1){
            return 0;
        }
        if(grid[sr][sc] ==2 ){
            if(zero == 0){
                return 1;
            }
            return 0;
        }

        grid[sr][sc] = -1;
        zero--;
        int count = dfs(sr+1,sc,zero,grid) + dfs(sr,sc+1,zero,grid)+
                    dfs(sr-1,sc,zero,grid) + dfs(sr,sc-1,zero,grid);
        grid[sr][sc] = 0;
        zero++;

        return count;
    }
}