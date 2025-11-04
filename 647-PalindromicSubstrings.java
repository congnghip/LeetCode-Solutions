class Solution {
    public int countSubstrings(String s) {
        int dem =0;
        for (int i=0;i<s.length();i++)
        {
            dem += expand(s,i,i);
            dem += expand(s,i,i+1);
        }
        return dem;
    }
    public int expand(String s, int l, int r)
    {
        int dem = 0;
        while (l>=0 && r <s.length() && s.charAt(l)==s.charAt(r))
        {
            dem++;
            l--;
            r++;
        }
        return dem;
    }
}