class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        int grid[][] = new int[n][m];

        Queue<Pair>q = new LinkedList<>(); 
        q.add(new Pair(entrance[0],entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.row;
            int y = p.col;
            for(int i=0;i<4;i++){
                int r = x + dr[i]; 
                int c = y + dc[i];
                if(r >= 0 && c >= 0 && r < n && c < m && maze[r][c] =='.'){
                grid[r][c] = grid[x][y]+1;
                if(r == 0 || c == 0 || r == n-1 || c == m-1){
                   return grid[r][c]; 
                }
                q.add(new Pair(r,c));
                maze[r][c] = '+';
             }
            }
        }
       return -1;
    }
}