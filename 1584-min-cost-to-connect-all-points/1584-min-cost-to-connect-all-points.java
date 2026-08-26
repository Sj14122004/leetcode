class Solution {
    class Triplet implements Comparable<Triplet> {
        int node;
        int parent;
        int dist;
        Triplet(int node, int parent, int dist) {
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }
        public int compareTo(Triplet t) {
            if(this.dist == t.dist) return this.node - t.node;
            return this.dist - t.dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int n = points.length;
        boolean[] vis = new boolean[n];
        int ans = 0;
        pq.add(new Triplet(0,-1,0));
        while(pq.size() > 0) {
            Triplet top = pq.remove();
            int node = top.node;
            int parent = top.parent;
            int dist = top.dist;
            if(vis[node] == true) continue;
            ans += dist;
            vis[node] = true;
            for(int i = 0; i < n; i++) {
                if(vis[i] == true || i == parent || i == node ) continue;
                int x1 = points[node][0], y1 = points[node][1];
                int x2 = points[i][0], y2 = points[i][1];
                int sum = Math.abs(x2-x1) + Math.abs(y2-y1);
                pq.add(new Triplet(i,node,sum));
            }
        }
        return ans;
    }
}