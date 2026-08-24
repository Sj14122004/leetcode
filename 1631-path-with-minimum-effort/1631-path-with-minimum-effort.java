class Solution {
    class Triplet implements Comparable<Triplet>{
        int r;
        int c;
        int eff;
        Triplet(int r,int c, int eff){
            this.r = r;
            this.c = c;
            this.eff = eff;
        } 
        public int compareTo(Triplet t) {
            if(this.eff == t.eff) return this.r - t.r;
            return this.eff - t.eff;
        }
    } 
    public int minimumEffortPath(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int ans[][]  = new int [m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        ans[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while(pq.size() > 0) {
            Triplet top = pq.remove();
            int r = top.r;
            int c = top.c;
            int eff = top.eff;
            if(r > 0){  //going up
                int e = Math.abs(arr[r][c] - arr[r-1][c]);
                e = Math.max(e,eff);
                if(ans[r-1][c] > e) {
                    ans[r-1][c] = e;
                    pq.add(new Triplet(r-1,c,e));
                }
            }
            if(c > 0){ // going left col-1
                int e = Math.abs(arr[r][c] - arr[r][c-1]);
                e = Math.max(e,eff);
                if(ans[r][c-1] > e) {
                    ans[r][c-1] = e;
                    pq.add(new Triplet(r,c-1,e));
                }
            }
            if(r < m-1) { // going right
                int e = Math.abs(arr[r][c] - arr[r+1][c]);
                e = Math.max(e,eff);
                if(ans[r+1][c] > e) {
                    ans[r+1][c] = e;
                    pq.add(new Triplet(r+1,c,e));
                }
            }
            if(c < n-1) { //going down
                int e = Math.abs(arr[r][c] - arr[r][c+1]);
                e = Math.max(e,eff);
                if(ans[r][c+1] > e) {
                    ans[r][c+1] = e;
                    pq.add(new Triplet(r,c+1,e));
                }
            }
        }
        return ans[m-1][n-1];
    }
}