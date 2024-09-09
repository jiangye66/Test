//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2287 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
//时间o(n*2^n),空间o(n)
class Solution {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return result;
    }

    private void dfs(int[] nums, int index){
        if(path.size() > nums.length)   return;
        result.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
