class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> qu = new LinkedList<>();
        qu.add(source);
        boolean[] check = new boolean[n];
        check[source] = true;
        while(!qu.isEmpty()){
            int top = qu.remove();
            for(int i = 0; i < list.get(top).size(); i++){
                if(!check[list.get(top).get(i)]){
                    qu.add(list.get(top).get(i));
                    check[list.get(top).get(i)] = true;
                    if(list.get(top).get(i) == destination) return true;
                }
            }
            
        }
        if(!check[destination]) return false;
        else return true;
    }
}