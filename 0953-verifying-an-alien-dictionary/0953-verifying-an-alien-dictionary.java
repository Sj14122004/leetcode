class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int [] str = new int [26];
        for(int i = 0; i < order.length(); i++){
            str[order.charAt(i) - 'a' ] = i;
        }
        for(int i = 0; i < words.length-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
        
        int j = 0;
        while( j < w1.length() && j < w2.length()){
            char ch1 = w1.charAt(j);
            char ch2 = w2.charAt(j);

            if(ch1 != ch2) {
                if(str[ch1-'a'] > str[ch2-'a']) {
                    return false;
                   
                }
                 break;
            }
            j++;
        }

         if(j == w2.length() && w1.length() > w2.length()){
            return false;
        
        }
        }
        return true;
    }
}