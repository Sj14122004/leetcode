class Solution {
    public void nextPermutation(int[] nums) {
        int piv = -1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                piv = i;
                break;
            }
        }
        int a = nums.length-1;
        if(piv != -1) {
            while(nums[a] <= nums[piv]) {
                a--;
            }
            int temp = nums[a];
            nums[a] = nums[piv];
            nums[piv] = temp;
        }
        int k = nums.length - 1;
        int l = piv+1;
        while(l < k) {
            int temp = nums[l];
            nums[l] = nums[k];
            nums[k] = temp;
            l++;
            k--;
        }
    }
}