class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
        public int compareTo(Pair p) {
            if(this.time == p.time) return this.node - p.node;
            return this.time - p.time;
        }
    } 
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < times.length; i++){
            int a = times[i][0], b = times[i][1], c = times[i][2];
            list.get(a).add(new Pair(b,c));
        }
       int [] time = new int [n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        time[k] = 0;
        while(pq.size() > 0) {
            Pair top = pq.remove();
            int node = top.node, dist = top.time;
            for(Pair p : list.get(node)) {
                int totalTime = top.time + p.time;
                if(totalTime < time[p.node]){
                    time[p.node] = totalTime;
                    pq.add(new Pair(p.node,totalTime));
                }
            }
            
        }
        int max = -1;
        for(int i = 1; i < time.length; i++){
            if(time[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max,time[i]);
        }
        return max;
    }
}