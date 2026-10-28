class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length; 
        int m = grid[0].length;


        int dp[][][] = new int[n][m][1025];
        for(int d[][]:dp){
           for(int d1[]:d){
             Arrays.fill(d1,-1);
           }
        }
        return min(grid,n-1,m-1,0,dp);
    }
    public int min(int grid[][],int i,int j,int xor,int dp[][][]){
        if(i == 0 && j == 0){
            return xor^grid[0][0];
        }
        if(dp[i][j][xor] != -1){
            return dp[i][j][xor];
        }
        int left = Integer.MAX_VALUE; 
        if(i-1 >=0 ){
          left = min(grid,i-1,j,xor^grid[i][j],dp);
        }
        int top = Integer.MAX_VALUE; 
        if(j-1 >=0 ){
         top  = min(grid,i,j-1,xor^grid[i][j],dp);
        }
        return dp[i][j][xor] =  Math.min(left,top);
    }
}