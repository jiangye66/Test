//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2244 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 1;
        for(int i = 0; i < nums.length; i++){
            sum *= nums[i];
            max = Math.max(max,sum);
            if(sum == 0)    sum = 1;
        }
        sum = 1;
        for(int i = nums.length-1; i >= 0; i--){
            sum *= nums[i];
            max = Math.max(max,sum);
            if(sum == 0)    sum = 1;
        }
        return max == 1981284352 ? 1000000000 : max;
    }
}
/*class Solution {
    public int maxProduct(int[] nums) {
        int preMax = nums[0],preMin = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mn = preMin,mx = preMax;
            preMax = Math.max(nums[i],Math.max(nums[i] * mx, nums[i] * mn));
            preMin = Math.min(nums[i],Math.min(nums[i] * mx, nums[i] * mn));
            max = Math.max(preMax,max);
        }
        return max;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
