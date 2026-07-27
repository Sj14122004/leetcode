class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : nums){
            pq.add(ele);
        }
        int a = pq.remove();
        int b = pq.remove();
        return (a-1)*(b-1);
    }
}