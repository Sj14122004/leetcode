class Solution {
    public int maxArea(int[] height) {
        int i = 0; 
        int j = height.length-1;
        int w = 0;
        while(i < j) {
            int width = j-i;
            int ans = Math.min(height[i],height[j]) * width;
            w = Math.max(w,ans);
            if(height[i] < height[j]) {
                i++;
            }else{
                j--;
            }
        }
        return w;
    }
}