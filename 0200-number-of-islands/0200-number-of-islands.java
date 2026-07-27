class Solution {
// class pair {
//     int row;
//     int col;
//     pair(int row, int col) {
//         this.row = row;
//         this.col = col;
//     }
// }
// void bfs(int i, int j,char[][] grid, boolean[][] vis){
//     int l = grid.length, m = grid[0].length;
//     Queue<pair> qu = new LinkedList<>();
//     qu.add(new pair(i,j));
//     while(!qu.isEmpty()){
//         pair top = qu.remove();
//         int a = top.row, b = top.col;
//         if(a > 0 && grid[a-1][b]=='1' && vis[a-1][b] == false){
//             qu.add(new pair(a-1,b));
//             vis[a-1][b] = true;
//         }
//         if(b > 0 && grid[a][b-1] == '1' && vis[a][b-1] == false){
//             qu.add(new pair(a,b-1));
//             vis[a][b-1] = true;
//         }
//         if(a+1 < l && grid[a+1][b] == '1' && vis[a+1][b] == false){
//             qu.add(new pair(a+1,b));
//             vis[a+1][b] = true;
//         }
//         if(b+1 < m && grid[a][b+1] == '1' && vis[a][b+1] == false){
//             qu.add(new pair(a,b+1));
//             vis[a][b+1] = true;
//         }
        
//     }
// }
    
// void dfs(int i, int j,char[][] grid, boolean[][] vis){
//     int l = grid.length, m = grid[0].length;

//     if(a > 0 && grid[a-1][b]=='1' && vis[a-1][b] == false){
//         vis[a-1][b] = true;
//     }
//     if(b > 0 && grid[a][b-1] == '1' && vis[a][b-1] == false){
//         qu.add(new pair(a,b-1));
//         vis[a][b-1] = true;
//     }
//     if(a+1 < l && grid[a+1][b] == '1' && vis[a+1][b] == false){
//         qu.add(new pair(a+1,b));
//         vis[a+1][b] = true;
//     }
//     if(b+1 < m && grid[a][b+1] == '1' && vis[a][b+1] == false){
//         qu.add(new pair(a,b+1));
//         vis[a][b+1] = true;
//     }
    
//     }
// }
    void dfs(int i, int j,char[][] grid, boolean[][] vis){
        vis[i][j] = true;
        if(i-1 >= 0 && vis[i-1][j] == false && grid[i-1][j] == '1') dfs(i-1,j,grid,vis);
        if(i+1 < grid.length && vis[i+1][j] == false && grid[i+1][j] == '1') dfs(i+1,j,grid,vis);
        if(j-1 >= 0 && vis[i][j-1] == false && grid[i][j-1] == '1') dfs(i,j-1,grid,vis);
        if(j+1 < grid[i].length && vis[i][j+1] == false && grid[i][j+1] == '1') dfs(i,j+1,grid,vis);
    }
    public int numIslands(char[][] grid) {
        int l = grid.length, m = grid[0].length;
        boolean [][] vis = new boolean[l][m];
        int count = 0;
        for(int i = 0; i < l; i++){
            for (int j = 0; j < m; j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    // bfs(i,j,grid,vis);
                    
                    dfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
        }
}