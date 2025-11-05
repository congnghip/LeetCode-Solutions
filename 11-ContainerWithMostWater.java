class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int index = 0;
        while (l<r)
        {
            if (index < (r - l)*Math.min(height[l],height[r]))
            {
                index = (r - l)*Math.min(height[l],height[r]);
            }
            if (height[l]>height[r])
            {
                r--;
            } else 
            {
                l++;
            }
        }
        return index;
    }
}