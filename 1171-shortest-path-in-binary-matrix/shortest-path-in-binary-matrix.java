class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1) return -1;



        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(0,0));
        grid[0][0] = 1;

        int dr[] = {0,0,-1,1,-1,1,1,-1}; 
        int dc[] = {1,-1,0,0,1,-1,1,-1};

        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.row;
            int y = p.col;
            for(int i=0;i<8;i++){
                int r = x + dr[i];
                int c = y + dc[i];
                if(r>=0  && c>=0  && r<grid.length && c<grid.length && grid[r][c] == 0){
                    q.add(new Pair(r,c));
                    grid[r][c] = grid[x][y] + 1; 
                }
            }
        }
        if(grid[grid.length-1][grid.length-1] == 0)return -1;
        return grid[grid.length-1][grid.length-1];
    }
}