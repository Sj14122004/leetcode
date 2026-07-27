class Solution {
    void dfs(List<List<Integer>>  list,int source,boolean[] check){
        check[source] = true;
        for(int i = 0; i < list.get(source).size(); i++){
            if(check[list.get(source).get(i)] == false ) dfs(list,list.get(source).get(i),check);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        boolean[] check = new boolean[n];
        dfs(list,source,check);   
        
        if(!check[destination]) return false;
        else return true;
    }
}