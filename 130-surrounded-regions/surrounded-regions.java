class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            if(board[i][0] == 'O'){
                dfs(i,0,board,m,n);
            }
            if(board[i][n-1] == 'O'){
                dfs(i,n-1,board,m,n);
            }
        }

        for(int j=0;j<n;j++){
            if(board[0][j] == 'O'){
                dfs(0,j,board,m,n);
            }
            if(board[m-1][j] == 'O'){
                dfs(m-1,j,board,m,n);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                   board[i][j] = 'X'; 
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(int i,int j,char grid[][],int n ,int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] != 'O'){
            return;
        }
        grid[i][j] = '#';

        dfs(i+1,j,grid,n,m);
        dfs(i,j+1,grid,n,m);
        dfs(i-1,j,grid,n,m);
        dfs(i,j-1,grid,n,m);
    }
}