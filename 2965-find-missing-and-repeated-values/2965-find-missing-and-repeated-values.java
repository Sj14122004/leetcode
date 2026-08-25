class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int freq[] = new int[n*n+1];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                freq[grid[i][j]]++;
            }
        }
        int d = -1;
        int m = -1;
        for(int i = 1; i <= n*n; i++){
            if(freq[i] == 2) d = i;
            if(freq[i] == 0) m = i;
        }
        return new int[]{d,m};
    }
}