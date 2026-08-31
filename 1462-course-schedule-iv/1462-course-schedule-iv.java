class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] qur) {
        boolean chk[][] = new boolean[n][n];
        for(int i = 0; i < pre.length; i++) {
            int a = pre[i][0];
            int b = pre[i][1];
            chk[a][b] = true;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(j == k) continue;
                    chk[j][k] = chk[j][k] || (chk[j][i] && chk[i][k]);
                }
            }
        }
        List<Boolean> list = new ArrayList<>();
        for(int [] qu : qur) {
            int a = qu[0];
            int b = qu[1];
            list.add(chk[a][b]);        
        }
        return list;
    }
}