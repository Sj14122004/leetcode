class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int [][] arr = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        int[] count = new int[nums.length];
        mergesort(0,nums.length-1,arr,count);
        List<Integer> list = new ArrayList<>();
        for(int x : count) {
            list.add(x);
        }
        return list;
    }
    void mergesort(int st, int end,int [][] arr, int [] count) {
        if(st >= end) return ;
        int mid = st + (end-st)/2;
        mergesort(st,mid,arr,count);
        mergesort(mid+1,end,arr,count);
        merge(st,mid,end,arr,count); 
    }

    void merge(int st,int mid, int end, int[][] arr, int[] count) {
        int [][] temp = new int[end-st+1][2];
        int i = st;
        int j = mid+1;
        int k = 0;

        int prevCount = 0;
        while(i <= mid && j <= end) {
            if(arr[i][0] > arr[j][0]) {
                temp[k++] = arr[j++];
                prevCount++;
            }else {
                count[arr[i][1]] += prevCount;
                temp[k++] = arr[i++];
            }
        }
        while(i<= mid) {
            count[arr[i][1]] += prevCount;
            temp[k++] = arr[i++];
        }
        while(j <= end) {
            temp[k++] = arr[j++];
        }
        for(int idx = 0; idx < temp.length; idx++) {
            arr[idx+st] = temp[idx];
        }
    }
}