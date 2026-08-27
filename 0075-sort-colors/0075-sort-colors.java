class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0; 
        int h = nums.length - 1;
        while(m <= h) {
            if(nums[m] == 0) {
                int t = nums[m];
                nums[m] = nums[l];
                nums[l] = t;
                m++;
                l++;
            }
            else if(nums[m] == 1) {
                m++;
            }
            else if(nums[m] == 2) {
                int t = nums[m];
                nums[m] = nums[h];
                nums[h] = t;
                h--;
            }
        }
    }
}