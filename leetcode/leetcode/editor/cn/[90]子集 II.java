//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 1206 👎 0


import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntToDoubleFunction;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int cur) {
        result.add(new ArrayList<>(path));
        if (cur == nums.length) {
            return;
        }

        for (int i = cur; i < nums.length; i++) {
            if (i > cur && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1); // 正确传递 cur + 1
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
