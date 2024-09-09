//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2451 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    //深度优先，时间O(mn)，空间O(mn)
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    bfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int[][] visited, int x, int y){
        if(grid[x][y] == '0' || visited[x][y] == 1)   return;
        visited[x][y] = 1;
        for(int i = 0; i < 4; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length) {
                dfs(grid,visited,nextX,nextY);
            }
        }
    }


    private void bfs(char[][] grid, int[][] visited, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = 1;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int i = 0; i < 4; i++){
                int nextX = pos[0] + dir[i][0];
                int nextY = pos[1] + dir[i][1];
                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length) {
                    if(visited[nextX][nextY] == 0 && grid[nextX][nextY] == '1'){
                        queue.offer(new int[]{nextX,nextY});
                        visited[nextX][nextY] = 1;
                    }
                }
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
