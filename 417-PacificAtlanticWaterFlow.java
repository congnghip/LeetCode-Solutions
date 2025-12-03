import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < n; i++)
        {
            dfs(heights,0,i,pacific);
        }
        for (int i = 0; i < m; i++)
        {
            dfs(heights,i,0,pacific);
        }

        for (int i = 0; i < n; i++)
        {
            dfs(heights,m-1,i,atlantic);
        }
        for (int i = 0; i < m; i++)
        {
            dfs(heights,i,n-1,atlantic);
        }

        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (pacific[i][j] && atlantic[i][j])
                {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }   
            }
        }
        return result;
    }
    public void dfs(int[][] heights, int i, int j,boolean[][] visited)
    {
        int m = heights.length;
        int n = heights[0].length;
        
        if (i<0 || j<0 || i>=m || j>=heights[0].length)
        {
            return;
        }
        if (visited[i][j])
        {
            return;
        }
        visited[i][j] = true;
        if (i+1<m && !visited[i+1][j] && heights[i+1][j] >= heights[i][j])
        {
            dfs(heights,i+1,j,visited);
        }
        if (j+1<n && !visited[i][j+1] && heights[i][j+1] >= heights[i][j])
        {
            dfs(heights,i,j+1,visited);
        }
        if (i-1>=0 && !visited[i-1][j] && heights[i-1][j] >= heights[i][j])
        {
            dfs(heights,i-1,j,visited);
        }
        if (j-1>=0 && !visited[i][j-1] && heights[i][j-1] >= heights[i][j])
        {
            dfs(heights,i,j-1,visited);
        }
    }
}