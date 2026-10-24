class Pair{
    int row;
    int col ;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int freshOrange  = 0;

        Queue<Pair>q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j] == 1){
                    freshOrange++;
                }
            }
        }
        if(freshOrange == 0)return 0;

        int dr[] = {0,0,-1,1};
        int dc[] = {1,-1,0,0};

        int minutes  = 0;

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                Pair p = q.remove();
                int r = p.row;
                int c = p.col;
                for(int j=0;j<4;j++){
                    int x =  r + dr[j];
                    int y =  c + dc[j];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                        q.add(new Pair(x,y));
                        grid[x][y] = 2;
                        freshOrange--;
                    }
                }
            }
            minutes++;
        }
        return freshOrange == 0 ?minutes-1:-1;
    }
}