class Solution {
    public int maxProduct(int[] nums) {
        int letfProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];
        for (int i = 0;i<nums.length;i++)
        {
            letfProduct = letfProduct == 0 ? 1 : letfProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            letfProduct *= nums[i];
            rightProduct *= nums[nums.length - 1 - i];

            ans = Math.max(ans,Math.max(letfProduct,rightProduct));
        }
        return ans;
    }
}