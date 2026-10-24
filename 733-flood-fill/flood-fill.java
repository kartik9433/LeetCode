class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        
        int oldcolor = image[sr][sc];
        if(oldcolor == color){
            return image;
        }
        image[sr][sc] = color;

        int dr[] = {0,0,-1,1}; 
        int dc[] = {1,-1,0,0};

        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.row;
            int y = p.col;
            for(int i=0;i<4;i++){
                int r = x + dr[i];
                int c = y + dc[i];
                if(r>=0 && c>=0 && r<image.length && c<image[0].length && image[r][c] == oldcolor){
                    q.add(new Pair(r,c));
                    image[r][c] = color;
                }
            }
        }
        return image;
    }
}