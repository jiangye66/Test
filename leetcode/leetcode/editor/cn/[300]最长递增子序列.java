//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 3599 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
//时间复杂度O(nlogn)，空间复杂度O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int l = 0, r = list.size()-1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(list.get(mid) < num){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            if(l >= list.size()) list.add(num);
            else list.set(l,num);
        }
        return list.size();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
