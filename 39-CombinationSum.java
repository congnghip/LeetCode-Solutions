import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();;
        backtrack(candidates,target,0,0,path,res);
        return res;
    }
    public void backtrack(int[] candidates, int target, int start, int sum, List<Integer> path, List<List<Integer>> res)
    {
        if (sum == target)
        {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = start;i<candidates.length;i++)
        {
            if (sum + candidates[i] > target)
            {
                break;
            }
            path.add(candidates[i]);
            backtrack(candidates,target,i,sum + candidates[i],path,res);
            path.remove(path.size()-1);
        }
    }
}