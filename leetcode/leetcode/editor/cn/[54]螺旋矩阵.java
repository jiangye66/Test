//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1659 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int l = 0, r = matrix[0].length-1;
        int u = 0, d = matrix.length-1;
        while(true){
            for(int i = l; i <= r; i++){
                result.add(matrix[u][i]);
            }
            if(++u > d) break;
            for(int i = u; i <= d; i++){
                result.add(matrix[i][r]);
            }
            if(--r < l) break;
            for(int i = r; i >= l; i--){
                result.add(matrix[d][i]);
            }
            if(--d < u) break;
            for(int i = d; i >= u; i--){
                result.add(matrix[i][l]);
            }
            if(++l > r) break;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
