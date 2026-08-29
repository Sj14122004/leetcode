class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));
        int n = arr.length;
        List<int[]> list = new ArrayList<>();
        int start = arr[0][0];
        int end = arr[0][1];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i][0] <= end) {
                end = Math.max(end, arr[i][1]);
            }else {
                list.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
            
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][]);
    }
}