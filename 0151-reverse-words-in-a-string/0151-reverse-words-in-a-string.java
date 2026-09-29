class Solution {
    public String reverseWords(String s) {
        String word = new StringBuilder(s).reverse().toString();
        String chk = "";
        String ans = "";
        for(int i = 0; i < word.length(); i++) {
            while(i < word.length() && word.charAt(i) != ' ') {
                chk += word.charAt(i);
                i++;
            }
            if(chk.length() > 0){
            ans += " " + new StringBuilder(chk).reverse().toString();
            }
            chk = "";
        }
        return ans.substring(1);
    }
}