//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2871 👎 0


import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
//时间复杂度O(n^2)，空间复杂度O(n)
class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        dfs(nums,visited);
        return result;
    }

    private void dfs(int[] nums,int[] visited){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            path.add(nums[i]);
            dfs(nums,visited);
            path.remove(path.size()-1);
            visited[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
