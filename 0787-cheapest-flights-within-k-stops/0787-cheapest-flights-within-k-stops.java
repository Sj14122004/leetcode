class Solution {
    public class Pair {
        int node;
        int cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public class Triplet {
        int node;
        int cost;
        int stop;
        Triplet(int node, int cost, int stop) {
            this.node = node;
            this.cost = cost;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < flights.length; i++){
            int source = flights[i][0];
            int destination = flights[i][1];
            int price = flights[i][2];
            adj.get(source).add(new Pair(destination, price));
        }
        int ans[] = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src] = 0;
        Queue<Triplet> qu = new LinkedList<>();
        qu.add(new Triplet(src,0,0));
        while(qu.size() > 0) {
            Triplet top = qu.remove();
            int node = top.node;
            int cost = top.cost;
            int stop = top.stop;
            if(stop == k+1) continue;
            for(Pair P : adj.get(node)) {
                int totalCost = cost + P.cost;
                if(totalCost < ans[P.node]) {
                    ans[P.node] = totalCost;
                    qu.add(new Triplet(P.node, totalCost, stop + 1));
                }
            }
        }
        if(ans[dst] == Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
}