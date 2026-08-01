class Solution {
    class Pair implements Comparable<Pair> {
        int node;
        double prob;
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
        public int compareTo(Pair p) {
            if(this.prob == p.prob) return this.node - p.node;
            return Double.compare(this.prob,p.prob); 
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0], b = edges[i][1];
            Double pr = succProb[i];
            list.get(a).add(new Pair(b,pr));
            list.get(b).add(new Pair(a,pr));
        }
        double ans[] = new double[n];
        ans[start] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(start,1));
        while(pq.size() > 0) {
            Pair top = pq.remove();
            int node = top.node;
            double prob = top.prob;
            if(ans[node] > prob) continue;
            for(Pair p : list.get(node)) {
                double totalProb = prob*p.prob;
                
                if(totalProb > ans[p.node]){
                    ans[p.node] = totalProb;
                    pq.add(new Pair(p.node,totalProb));
                }
            }
        }
        return ans[end];
    }
}