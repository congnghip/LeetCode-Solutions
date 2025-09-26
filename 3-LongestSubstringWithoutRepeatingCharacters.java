import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int L=0, R=0;
        int lenMax =0;

        while (R < s.length()){
            char c = s.charAt(R);
            while (set.contains(c)){
                set.remove(s.charAt(L));
                L++;
            }
            set.add(c);
            R++;
            lenMax = Math.max(lenMax, R - L);
        }
        return lenMax;
    }
}