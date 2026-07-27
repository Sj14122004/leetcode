class Solution {
    public boolean isBipartite(int[][] graph) {
        int visit[] = new int[graph.length];
        Arrays.fill(visit,-1);
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i < graph.length; i++){
            if(visit[i] != -1) continue;
            qu.add(i);
            visit[i] = 1;
            while(!qu.isEmpty()){
                int top = qu.remove();
                for(int j = 0; j < graph[top].length; j++){
                    if(visit[graph[top][j]] == -1){
                        qu.add(graph[top][j]);
                        if(visit[top] == 1) visit[graph[top][j]] = 0;
                        else visit[graph[top][j]] = 1;
                    }else if(visit[top] == visit[graph[top][j]]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}