class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] ans = new int[nums.length];
        int temp = 1;
        ans[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        for(int i = ans.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * temp;
            temp = temp * nums[i];
        }
        return ans;
    }
}