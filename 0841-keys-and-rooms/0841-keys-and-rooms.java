class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);
        boolean [] check = new boolean[rooms.size()];
        check[0] = true;
        while(!qu.isEmpty()){
            int top = qu.remove();
            for(int i = 0; i < rooms.get(top).size(); i++){
                if(!check[rooms.get(top).get(i)]){
                    qu.add(rooms.get(top).get(i));;
                    check[rooms.get(top).get(i)] = true;
                }
            }
        }
        for(boolean i:check){
            if(!i) return false;
        }
        return true;
    }
}