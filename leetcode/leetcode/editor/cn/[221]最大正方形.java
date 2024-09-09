//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1659 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//时间O(mn),空间O(mn)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[][] dp = new int[row+1][col+1];
        for(int i = 1; i < row + 1; i++){
            for(int j = 1; j < col + 1; j++){
                if(matrix[i-1][j-1] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
