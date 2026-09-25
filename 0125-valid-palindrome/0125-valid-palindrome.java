class Solution {
    public boolean isPalindrome(String s) {
        Stack<Character> st = new Stack<>();
        String chk = "";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!Character.isDigit(ch)){
            if(!Character.isLetter(ch)) {
                continue;
            }
            }
            chk += Character.toLowerCase(ch);
            st.push(Character.toLowerCase(ch));
        }
        String ans = "";
        while(!st.isEmpty()) {
            ans += st.pop();
        }
        if(chk.equals(ans)) return true;
        return false;
    }
}