class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        int [] indeg = new int[n]; 
        for(int i  = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < graph[i].length; j++){
                list.get(graph[i][j]).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i < n; i++){
                if(indeg[i] == 0){
                    qu.add(i);
                }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!qu.isEmpty()){
            int top = qu.remove();
            ans.add(top);
           
            for(int j = 0; j < list.get(top).size(); j++){
                indeg[list.get(top).get(j)]--;
                if(indeg[list.get(top).get(j)] == 0){
                    qu.add(list.get(top).get(j));
                }
            }
            
        }
        Collections.sort(ans);
        return ans;
    }
}