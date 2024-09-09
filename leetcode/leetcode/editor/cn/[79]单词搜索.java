//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1820 👎 0


import java.sql.SQLOutput;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        this.visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] != word.charAt(0))   continue;
                dfs(board,word,i,j,0);
                if(result == true)  return true;
            }
        }
        return false;
    }

    private void dfs(char[][] board, String word, int x, int y, int index){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || index >= word.length()) return;
        if(visited[x][y] == true || word.charAt(index) != board[x][y])   return;
        if(index == word.length()-1){
            result = true;
            return;
        }

//        System.out.println(board[x][y]);
        for(int i = 0; i < 4; i++){
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            visited[x][y] = true;
            dfs(board,word,nextX,nextY,index + 1);
            visited[x][y] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
