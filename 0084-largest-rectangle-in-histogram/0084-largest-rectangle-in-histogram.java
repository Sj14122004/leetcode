class Solution {
    int ans = 0;
    public int largestRectangleArea(int[] heights) {
        int l = heights.length;
        int left[] = new int[l];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < l; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = st.peek();
            }
            st.push(i);
        }
        int right[] = new int[l];
        st.clear();
        for(int i = l-1; i >= 0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                right[i] = l;
            }else{
                right[i] = st.peek();
            }
            st.push(i);
        }

        for(int i = 0; i < l; i++) {
            int area = heights[i] * (right[i] - left[i] - 1);
            ans = Math.max(ans,area);
        }
        return ans;
    }
}