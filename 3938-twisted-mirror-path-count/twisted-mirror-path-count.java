class Solution {
    int n;
    int m;
    int mod = (int)1e9+7;
    int left = 0;
    int top = 1;
    int dp[][][];
    public int uniquePaths(int[][] grid) {
        n  = grid.length;
        m  = grid[0].length;
        dp = new int[n][m][2];
        for(int a[][]:dp){
            for(int b[]:a){
                Arrays.fill(b,-1);
            }
        }
        return fun(0,0,grid,left);
    }
    public int fun(int i,int j,int grid[][],int camefrom){
        if(i>= n || j>=m ){
            return 0;
        }

        if(i == n-1 && j == m-1){
            return 1;
        }
        if(dp[i][j][camefrom]!=-1){
            return dp[i][j][camefrom];
        }
        int ans = 0;
        if(grid[i][j] == 1){
            if(camefrom == left ){
                return dp[i][j][camefrom] = fun(i+1,j,grid,top);
            }
            else{
                 return dp[i][j][camefrom] = fun(i,j+1,grid,left);
            }
        }
        else{
            return dp[i][j][camefrom] = (fun(i,j+1,grid,left) + fun(i+1,j,grid,top))% mod;
        }
    }
}