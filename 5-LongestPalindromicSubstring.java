class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1){
            return "";
        }
        String result = "";
        for (int i=0; i < s.length(); i++){
            String le = expand(s,i,i);
            String chan = expand(s,i,i+1);
            if (le.length() > result.length()) result = le;
            if (chan.length() > result.length()) result = chan;
        }
        return result;
    }
    private String expand(String s, int l, int r){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
        {
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
}