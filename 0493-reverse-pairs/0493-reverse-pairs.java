class Solution {
    public int count(int[] nums, int start, int mid, int end) {
        int j = mid+1;
        int count = 0;
        for(int i = start; i <= mid; i++) {
            while(j <= end && nums[i] > 2L*nums[j]) j++;
            count += j - (mid+1);
        }
        return count;
    }
    public void merge(int [] nums, int start , int mid, int end) {
        int i = start;
        int j = mid+1;
        int [] temp = new int[end-start+1];
        int c = 0;
        while(i <= mid && j <= end) {
            if(nums[i] <= nums[j]) {
                temp[c++] = nums[i++];
            }else {
                temp[c++] = nums[j++];
            }
        }
        while(i <= mid ){
            temp[c++] = nums[i++];
        }
        while(j <= end) {
            temp[c++] = nums[j++];
        }
        for(int x = 0; x < temp.length; x++) {
            nums[x+start] = temp[x];
        }
    }
    public int mergesort(int [] nums, int start, int end) {
        if(start >= end) {
            return 0;
        }
        int mid = start + (end-start)/2;
        int count = 0;
        count += mergesort(nums,start,mid);
        count += mergesort(nums,mid+1,end);
        count += count(nums,start,mid,end);
        merge(nums,start,mid,end);
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }
}