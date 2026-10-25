class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i,j,0,"",word,board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int i,int j,int k,String s,String word,char[][] board){
        if(k == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] =='.'|| board[i][j]!=word.charAt(k)){
            return false;
        }
        char temp =  board[i][j];
        board[i][j] = '.';

        boolean check1 = dfs(i+1, j, k+1, s, word, board);
        boolean check2 = dfs(i, j+1, k+1, s, word, board);
        boolean check3 = dfs(i-1, j, k+1, s, word, board);
        boolean check4 = dfs(i, j-1, k+1, s, word, board);

        board[i][j] = temp;

        return check1||check2||check3||check4;
    }
}