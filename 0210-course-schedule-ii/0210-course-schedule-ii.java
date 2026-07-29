class Solution {
    public int[] findOrder(int n, int[][] pre) {
                List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int ele []: pre){
            list.get(ele[1]).add(ele[0]);
        }
        int [] indeg = new int[n];
        Arrays.fill(indeg,0);
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.get(i).size(); j++){
                indeg[list.get(i).get(j)] += 1;
            }
        }
        Queue<Integer> qu = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < indeg.length; i++){
            if(indeg[i] == 0){
                qu.add(i);
            }
        }
        while(!qu.isEmpty()){
            int top = qu.remove();
            ans.add(top);
            for(int i = 0; i < list.get(top).size(); i++){
                indeg[list.get(top).get(i)]--;
                if(indeg[list.get(top).get(i)] == 0){
                    qu.add(list.get(top).get(i));
                }
            }
        }
        int [] sol = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            sol[i] = ans.get(i);
        }
        if(ans.size() != n)return new int[0];
        else return sol;
    }
}