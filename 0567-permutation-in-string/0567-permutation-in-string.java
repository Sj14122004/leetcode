class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq1[] = new int[26];
        
        for(int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            freq1[ch - 'a']++;
        }
        for(int i = 0; i < s2.length(); i++) {
            int idx = i;
            int freq2[] = new int[26];
            int j = 0;
            while(j < s1.length() && idx < s2.length()) {
                freq2[s2.charAt(idx) - 'a']++;
                idx++;
                j++;
            }
            if(Arrays.equals(freq1, freq2)) {
                return true;
            }
           
        }
         return false;
    }
}