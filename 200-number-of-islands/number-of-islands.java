class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    bfs(i,j,grid);
                    count++;
                }
            }
        }
        
        return count;
    }
    public void bfs(int sr ,int sc,char grid[][]){
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        grid[sr][sc] = '0';

        int dr[] = {0,0,1,-1}; 
        int dc[] = {-1,1,0,0};

        while(!q.isEmpty()){
           Pair p = q.remove();
           int r = p.row; 
           int c = p.col;
           for(int i=0;i<4;i++){
               int nrw =  r + dr[i];
               int ncl =  c + dc[i];
               if(nrw >= 0 && ncl>=0 && nrw <grid.length && ncl<grid[0].length &&
               grid[nrw][ncl] == '1'){
                q.add(new Pair(nrw,ncl));
                 grid[nrw][ncl] = '0';
               }
           }
        }
        return ;
    }
}