class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        int x = map.getOrDefault(0,0);
        for(int i = 0; i < x; i++) {
            nums[i] = 0;
        }
        int y = map.getOrDefault(1,0);
        for(int i = 0; i < y; i++) {
            nums[x+i] = 1;
        }
        int z = map.getOrDefault(2,0);
        for(int i = 0; i < z; i++) {
            nums[x+y+i] = 2;
        }
    }
}