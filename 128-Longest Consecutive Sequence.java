import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int num : nums){
            set.add(num);
        }
        int longest = 0;
        for (int num : set){
            if (!set.contains(num-1)){
                int curentNum = num;
                int streak = 1;
                while (set.contains(curentNum + 1)){
                    curentNum++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }
}
