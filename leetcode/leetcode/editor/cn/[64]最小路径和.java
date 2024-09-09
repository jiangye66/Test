//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1681 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//时间O(nm),空间O(nm)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < dp.length; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}




/*class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++)  dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int i = 1; i < n; i++)  dp[0][i] = dp[0][i-1] + grid[0][i];
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        dfs(dp,grid,m-1,n-1,sb);
        sb.reverse();
        String path = sb.toString();
        System.out.println(path);
        return dp[m-1][n-1];
    }

    private void dfs(int[][] dp, int[][] grid, int i, int j, StringBuilder sb){
        if(i == 0 && j== 0){
            sb.append(Integer.toString(grid[i][j]));
        }else if(i > 0 && dp[i][j] == dp[i-1][j] + grid[i][j]){
            sb.append(Integer.toString(grid[i][j])).append(">-");
            dfs(dp,grid,i-1,j,sb);
        }else if(j > 0 && dp[i][j] == dp[i][j-1] + grid[i][j]){
            sb.append(Integer.toString(grid[i][j])).append(">-");
            dfs(dp,grid,i,j-1,sb);
        }
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
