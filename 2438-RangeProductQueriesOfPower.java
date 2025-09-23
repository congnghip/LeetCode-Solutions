import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;
        List<Integer> powers = new ArrayList<>();
        for (int i=0;i<31;i++)
        {
            if ((n & (1<<i)) != 0)
            {
                powers.add(1<<i);
            }
        }
        int[] ans = new int[queries.length];
        for (int j =0;j<queries.length;j++)
        {
            long product = 1;
            for (int i=queries[j][0];i<=queries[j][1];i++)
            {
                product = (powers.get(i)*product)%MOD;
            }
            ans[j] = (int) product;
        }
        return ans;
    }
}