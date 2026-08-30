class Solution {
    int [][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    boolean back(char[][] board, String word, int i, int j,int idx) {
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '$') return false;
        if(board[i][j] != word.charAt(idx)) return false;
        for(int dir[] : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            char temp = board[i][j];
            board[i][j] = '$';
            if(back(board,word,ni,nj,idx+1)) {
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == word.charAt(0) && back(board,word,i,j,0)){
                    return true;
            }
        }
    }
    return false;
}
}