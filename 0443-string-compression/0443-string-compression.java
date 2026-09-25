class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int l = chars.length;
        for(int i = 0; i < l; i++){
           int j = i;
           int counter = 0;
           char ch = chars[i];
           while(j < l && ch == chars[j]){
            j++;
            i++;
            counter++;
           } 
           if(counter == 1) chars[idx++] = ch;
           else {
            chars[idx++] = ch;
            String str = Integer.toString(counter);
            for(int k = 0; k < str.length(); k++) {
                chars[idx++] = str.charAt(k);
            }
           }
           i--;
        }
        return idx;
    }
}