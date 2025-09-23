class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0)
        {
            return false;
        }
        int count = Integer.bitCount(n);
        if (count != 1)
        {
            return false;
        }
        return true;
    }
}