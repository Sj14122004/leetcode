class Solution {
    void bfs(int i , boolean[] visit, int [][] isConnected){
        visit[i] = true;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(i);
        int a = isConnected.length;
        while(!qu.isEmpty()) {
            int top = qu.remove();
            for(int j = 0; j < a; j++){
                if(isConnected[top][j] == 1 && visit[j] == false){
                    visit[j] = true;
                    qu.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int l = isConnected.length;
        boolean[] visit = new boolean[l];
        int count = 0;
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i < l; i++){
            if(!visit[i]){
                bfs(i,visit,isConnected);
                count++;
            } 
        }
        return count;
    }
}