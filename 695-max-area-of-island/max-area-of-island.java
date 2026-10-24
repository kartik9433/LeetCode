class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length; 
        int m = grid[0].length;

        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                   max = Math.max(max,bfs(i,j,grid));
                }
            }
        }
        return max;
    }
    public int  bfs(int sr,int sc,int grid[][]){
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(sr,sc));

        int area = 0;

        grid[sr][sc] = 0; // visited

        int dr[] = {0,0,-1,1};
        int dc[] = {1,-1,0,0}; 

        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.row;
            int y = p.col;
            area++;
            for(int i=0;i<4;i++){
                int r = x + dr[i];
                int c = y + dc[i];
                if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1){
                    q.add(new Pair(r,c));
                    grid[r][c] = 0;
                }
            }
        }
        return area;
    }
}