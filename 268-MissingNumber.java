class Solution {
    public int missingNumber(int[] nums) {
        int mix = nums.length;
        for (int i=0;i<nums.length;i++)
        {
            mix ^= i ^ nums[i];
        }
        return mix;
    }
}